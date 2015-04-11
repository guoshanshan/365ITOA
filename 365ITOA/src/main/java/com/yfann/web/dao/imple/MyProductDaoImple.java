package com.yfann.web.dao.imple;

import com.yfann.web.dao.MyProductDao;
import com.yfann.web.dao.common.imple.BaseDaoImple;
import com.yfann.web.model.MyProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Simon on 2015/4/7.
 */
@Repository("myProductDao")
public class MyProductDaoImple extends BaseDaoImple<MyProduct> implements MyProductDao<MyProduct> {
    /**
     * 批量保存我的课程(用于第三方支付回调程序的业务逻辑)
     *
     * @param myProductList
     */
    @Override
    public void batchSaveMyProduct(List<MyProduct> myProductList) {
        if (myProductList != null){
            for (int i = 0; i < myProductList.size(); i++) {
                hibernateTemplate.save(myProductList.get(i));
                //每执行50条刷新一次缓存
                if (i % 50 == 0){
                    hibernateTemplate.clear();
                    hibernateTemplate.flush();
                }
            }
        }
    }
}
