package com.yfann.web.action;

import com.yfann.web.model.Product;
import com.yfann.web.model.ProductKind;
import com.yfann.web.model.ProductLevel;
import com.yfann.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 产品控制器
 */
@Controller
@RequestMapping("/product")
public class ProductAction {
    @Autowired
    private ProductService productService;

    @RequestMapping("takeProductDatailImg")
    public void takeProductDatailImg(String id,HttpServletResponse response) throws Exception{
        response.getOutputStream().write(productService.takeProductDatailImg(id));
    }

    @RequestMapping("takeProductGreateImg")
    public void takeProductGreateImg(String id,HttpServletResponse response) throws Exception{
        response.getOutputStream().write(productService.takeProductGreateImg(id));
    }

    /**
     * 跳转到课程列表
     *
     * @return
     */
    @RequestMapping("/forwardProductList")
    public String forwardProductList(Model model) {

        //获取课程等级列表
        List<ProductLevel> productLevelList = productService.findAllProductLevelList();
        //获取课程分类列表
        List<ProductKind> productKindList = productService.findAllProductKindList();
        //获取产品列表
        List<Product> productList = productService.findAllProductList();
        model.addAttribute("productList", productList);
        model.addAttribute("productLevelList",productLevelList);
        model.addAttribute("productKindList",productKindList);
        return "shop/productList";
    }


    /**
     * 根据产品主键获取缩略图
     *
     * @param product
     * @param response
     * @throws Exception
     */
    @RequestMapping("/takeProductHeadImg")
    public void takeProductHeadImg(Product product, HttpServletResponse response) throws Exception {
        response.getOutputStream().write(productService.takeProductHeadImg(product.getId()));
    }

    /**
     * 跳转到产品页面
     *
     * @return
     */
    @RequestMapping("/forwardProduct")
    public String forwardProuct(Product product, Model model) {
        List<String> productDetailImgIdList =  productService.findProductDetailImgIdByProductId(product.getId());
        List<String> productGreateImgIdList = productService.findProductGreateImgIdByProductId(product.getId());
        model.addAttribute("product", productService.findProduct(product));
        model.addAttribute("productDetailImgIdList", productDetailImgIdList);
        model.addAttribute("productGreateImgIdList", productGreateImgIdList);
        return "shop/product";
    }
}
