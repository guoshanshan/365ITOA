package com.yfann.web.service.imple;

import com.yfann.web.dao.MyProductDao;
import com.yfann.web.model.MyProduct;
import com.yfann.web.service.MyProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Simon on 2015/4/7.
 */
@Service("myProductService")
public class MyProductServiceImple implements MyProductService {
    @Autowired
    private MyProductDao myProductDao;
    /**
     * 批量保存我的课程(用于第三方支付回调程序的业务逻辑)
     *
     * @param myProductList
     */
    @Override
    public void batchSaveMyProduct(List<MyProduct> myProductList) {
        myProductDao.batchSaveMyProduct(myProductList);
    }
}
