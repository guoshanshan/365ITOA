package com.yfann.web.action;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yfann.web.model.Order;
import com.yfann.web.model.OrderDetail;
import com.yfann.web.model.Product;
import com.yfann.web.model.User;
import com.yfann.web.service.OrderService;
import com.yfann.web.service.ProductService;
import com.yfann.web.utils.UUIDCreate;
import com.yfann.web.vo.ApplicationValue;
import com.yfann.web.vo.DicValue;
import com.yfann.web.vo.ShopCar;
import com.yfann.web.vo.ShopCarItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 订单控制器
 */
@Controller
@RequestMapping("/order")
public class OrderAction {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    /**
     * 跳转到支付订单
     *
     * @return
     */
    @RequestMapping("/forwardPayOrder")
    public String forwardPayOrder(Order orderInfo,HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("shopCar") == null) {
            //该方法已被当前线程执行过
            Order orderResult = orderService.findOrderById(orderInfo.getId());
            model.addAttribute("order", orderResult);
        } else {
            Order order = new Order();
            order.setId(UUIDCreate.takeUUID());
            order.setOrderId(UUIDCreate.takeUUID());
            order.setOrderCreateTime(new Date());
            //设置订单为未支付
            order.setOrderStatus(DicValue.OrderStatus.UN_PAY);
            //设置订单所属客户
            order.setUserId(((User) request.getSession().getAttribute(ApplicationValue.SESSION_USER)).getUserId());
            List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
            ShopCar shopCar = (ShopCar) request.getSession().getAttribute("shopCar");
            //设置订单总金额
            order.setOrderPrice(shopCar.getCountPrice());
            List<ShopCarItem> shopCarItemList = shopCar.getShopCarItems();
            for (ShopCarItem shopCarItem : shopCarItemList) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setId(UUIDCreate.takeUUID());
                orderDetail.setOrderId(order.getId());
                orderDetail.setProductId(shopCarItem.getProduct().getId());
                orderDetail.setPrice(shopCarItem.getSubCount());
                orderDetail.setProductCount(shopCarItem.getCount());
                orderDetailList.add(orderDetail);
            }
            order.setOrderDetailSet(new HashSet<OrderDetail>(orderDetailList));
            orderService.createOrder(order);
            //清空购物车
//            request.getSession().setAttribute("shopCar", null);
            model.addAttribute("order", order);
        }
        return "shop/payOrder";
    }

    /**
     * 跳转到订单确认页面
     *
     * @param model
     * @return
     */
    @RequestMapping("forwardSureOrder")
    public String forwardSureOrder(Model model) {
        Order order = new Order();
        order.setId(UUIDCreate.takeUUID());
        order.setOrderId(order.getId());
        order.setOrderCreateTime(new Date());
        model.addAttribute("order", order);
        return "shop/sureOrder";
    }

    /**
     * 跳转到购物车页面
     *
     * @return
     */
    @RequestMapping("/forwardShopCar")
    public String forwardShopCar() {
        return "shop/shopCar";
    }

    /**
     * 将课程添加到购物车(session域)
     *
     * @param product
     * @param request
     * @param response
     */
    @RequestMapping("/addShopCar")
    public void addShopCar(Product product, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        ShopCar shopCar = (ShopCar) session.getAttribute("shopCar");
        if (shopCar == null) {
            //seesion中没有购物车则添加
            ShopCar shopCarTemp = new ShopCar();
            shopCarTemp.setId(UUIDCreate.takeUUID());
            List<ShopCarItem> shopCarItems = shopCarTemp.getShopCarItems();
            if (shopCarItems == null) {
                shopCarTemp.setShopCarItems(new ArrayList<ShopCarItem>());
            }
            session.setAttribute("shopCar", shopCarTemp);
        }
        Product productInfo = productService.findProduct(product);
        //再次重新获取购物车
        orderService.addBuyCar((ShopCar) session.getAttribute("shopCar"), productInfo);
        response.getOutputStream().write("添加到购物成功".getBytes("utf-8"));
    }
}
