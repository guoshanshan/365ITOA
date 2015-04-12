package com.yfann.web.dao;

import com.yfann.web.dao.common.BaseDao;
import com.yfann.web.model.Order;

/**
 * Created by Simon on 2015/4/2.
 */
public interface OrderDao<T> extends BaseDao<T> {
    /**
     * 根据订单号查询订单
     * @param orderId
     * @return
     */
    public Order findOrderByOrderId(String orderId);
}
