package com.yfann.web.service;

import com.yfann.web.model.MyProduct;

import java.util.List;

/**
 * Created by Simon on 2015/4/7.
 */
public interface MyProductService {
    /**
     * 批量保存我的课程(用于第三方支付回调程序的业务逻辑)
     * @param myProductList
     */
    public void batchSaveMyProduct(List<MyProduct> myProductList);
}
