package com.yfann.web.vo;

/**
 * Created by Simon on 2015/4/6.
 */
public class DicValue {
    /**
     * 订单状态
     */
    public static class OrderStatus{
        /*未支付**/
        public static final String UN_PAY = "0";
        /*已支付**/
        public static final String ED_PAY = "1";
    }

    /**
     * 课程授权状态
     */
    public static class ProductAuthorizeStatus{
        /*未授权**/
        public static final String UN_AUTHORIZE = "0";
        /*授权中**/
        public static final String ING_AUTHORIZE = "1";
        /*已授权**/
        public static final String ED_AUTHORIZE = "2";
    }
}
