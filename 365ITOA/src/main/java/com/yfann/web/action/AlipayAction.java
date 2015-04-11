package com.yfann.web.action;

import com.yfann.web.model.MyProduct;
import com.yfann.web.model.Order;
import com.yfann.web.model.OrderDetail;
import com.yfann.web.service.MyProductService;
import com.yfann.web.service.OrderService;
import com.yfann.web.utils.AlipayNotify;
import com.yfann.web.utils.AlipaySubmit;
import com.yfann.web.utils.ReadProperties;
import com.yfann.web.utils.UUIDCreate;
import com.yfann.web.vo.ApplicationValue;
import com.yfann.web.vo.DicValue;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 支付宝支付模块
 */
@Controller
@RequestMapping("alipay")
public class AlipayAction {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MyProductService myProductService;

    @RequestMapping("forwardPay")
    public void forwardPay(Order order,HttpServletRequest request,HttpServletResponse response) throws Exception{
        //生成订单
        // 支付类型
        String payment_type = "1";
        // 必填，不能修改
        // 服务器异步通知页面路径
        // 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

        String notify_url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/alipay/notifyUrl" + ApplicationValue.APP_LAST_NAME;

        // 页面跳转同步通知页面路径
        // 需http://格式的完整路径，不能加?id=123这类自定义参数
        String return_url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/alipay!returnUrl" + ApplicationValue.APP_LAST_NAME;
        // 卖家支付宝帐户
        String seller_email = ReadProperties.getValue("account","pay");

        // 必填 //商户订单号
        String out_trade_no = order.getOrderId();
        if (!StringUtils.isNotBlank(out_trade_no)){
            throw new Exception("订单号为空,订单异常");
        }
        // 商户网站订单系统中唯一订单号，必填 //订单名称
        String subject = "356IT学院IT精品架构师系列视频课程";
        // 必填 //付款金额
        String total_fee = null;
        if (order != null && StringUtils.isNotBlank(order.getOrderId())){
            Order orderResult = orderService.findOrderByOrderId(order.getOrderId());
            if (orderResult != null && orderResult.getOrderPrice() != null){
                total_fee = orderResult.getOrderPrice().toString();
            }else {
                throw new Exception("订单支付异常");
            }

        }else {
            throw new Exception("订单支付异常");
        }

        // 必填 //订单描述 String body = new
        // String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
        // 商品展示地址
        String show_url = "";
        // 需以http://开头的完整路径，例如：http://www.商户网址.com/myorder.html //防钓鱼时间戳
        String anti_phishing_key = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/system/forwardIndex" + ApplicationValue.APP_LAST_NAME;
        // 若要使用请调用类文件submit中的query_timestamp函数 //客户端的IP地址
        String exter_invoke_ip = request.getRemoteAddr();
        // 非局域网的外网IP地址，如：221.0.0.1

        // ////////////////////////////////////////////////////////////////////////////////

        // 把请求参数打包成数组
        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("service", "create_direct_pay_by_user");
        //合作者身份ID
        sParaTemp.put("partner", ReadProperties.getValue("partner","pay"));
        //字符编码 input_charset
        sParaTemp.put("_input_charset", ReadProperties.getValue("input_charset","pay"));
        sParaTemp.put("payment_type", payment_type);
        sParaTemp.put("notify_url", notify_url);
        sParaTemp.put("return_url", return_url);
        sParaTemp.put("seller_email", seller_email);
        sParaTemp.put("out_trade_no", out_trade_no);
        sParaTemp.put("subject", subject);
        sParaTemp.put("total_fee", total_fee);
        // sParaTemp.put("body", body);
        sParaTemp.put("show_url", show_url);
        sParaTemp.put("anti_phishing_key", anti_phishing_key);
        sParaTemp.put("exter_invoke_ip", exter_invoke_ip);

        // 建立请求
        String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");
        response.getOutputStream().write(sHtmlText.getBytes("utf-8"));

    }


    /** 获取支付宝POST过来反馈信息 */
    @RequestMapping("/notifyUrl")
    public void notifyUrl(HttpServletRequest request){
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }

        // 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        // 商户订单号
        String out_trade_no = "";
        try {
            out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 支付宝交易号
        // String trade_no = "";
        // try {
        // trade_no = new
        // String(request.getParameter("trade_no").getBytes("ISO-8859-1"),
        // "UTF-8");
        // } catch (UnsupportedEncodingException e) {
        // e.printStackTrace();
        // }

        // 交易状态
        String trade_status = "";
        try {
            trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(trade_status);

        // 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

        if (AlipayNotify.verify(params)) {// 验证成功
            // ////////////////////////////////////////////////////////////////////////////////////////
            // 请在这里加上商户的业务逻辑程序代码

            // ——请根据您的业务逻辑来编写程序（以下代码仅作参考）——

            if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {
                Order orderResult = orderService.findOrderByOrderId(out_trade_no);
                //将订单设置为已支付
                orderResult.setOrderStatus(DicValue.OrderStatus.ED_PAY);
                //获取该订单课程详情
                List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>(orderResult.getOrderDetailSet());
                List<MyProduct> myProductList = new ArrayList<MyProduct>();
                for (OrderDetail orderDetail : orderDetailList){
                    for (int i = 0; i < orderDetail.getProductCount();i++){
                        MyProduct myProduct = new MyProduct();
                        myProduct.setId(UUIDCreate.takeUUID());
                        myProduct.setProductId(orderDetail.getProductId());
                        myProduct.setUserId(orderResult.getUserId());
                        myProduct.setAuthorizeStatus(DicValue.ProductAuthorizeStatus.UN_AUTHORIZE);
                        myProductList.add(myProduct);
                    }
                }
                myProductService.batchSaveMyProduct(myProductList);
            }

            // ——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

            // ////////////////////////////////////////////////////////////////////////////////////////
        } else {// 验证失败

        }
    }


    /** 获取支付宝GET过来反馈信息 */
    @RequestMapping("/returnUrl")
    public String returnUrl(HttpServletRequest request) {
        notifyUrl(request);
/*        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            params.put(name, valueStr);
        }

        // 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        // 商户订单号
        // try {
        // String out_trade_no = new
        // String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),
        // "UTF-8");
        // } catch (UnsupportedEncodingException e) {
        // e.printStackTrace();
        // }

        // 支付宝交易号
        // try {
        // String trade_no = new
        // String(request.getParameter("trade_no").getBytes("ISO-8859-1"),
        // "UTF-8");
        // } catch (UnsupportedEncodingException e) {
        // e.printStackTrace();
        // }

        // 交易状态
        String trade_status = "";
        try {
            trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

        // 计算得出通知验证结果
        boolean verify_result = AlipayNotify.verify(params);

        if (verify_result) {// 验证成功
            // ////////////////////////////////////////////////////////////////////////////////////////
            // 请在这里加上商户的业务逻辑程序代码

            // ——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
            if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {
                // 判断该笔订单是否在商户网站中已经做过处理
                // 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                // 如果有做过处理，不执行商户的业务程序
                return "forwardsuccess";
            }

        } else {
            // 该页面可做页面美工编辑
            return "forwardfail";
        }
        return "forwardMyOrderList";*/
        return null;
    }
}
