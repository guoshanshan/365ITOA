package com.yfann.web.dao.imple;

import com.yfann.web.dao.ProductDao;
import com.yfann.web.dao.common.imple.BaseDaoImple;
import com.yfann.web.model.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Simon on 2015/4/2.
 */
@Repository("productDao")
public class ProductDaoImple extends BaseDaoImple<Product> implements ProductDao<Product> {

    /**
     * 获取课程图片
     *
     * @param id
     * @return
     */
    @Override
    public byte[] takeProductImg(String id) {
        String hql = "select productImage from " + ProductImage.class.getName() + " where id = ?";
        return (byte[])hibernateTemplate.find(hql,new Object[]{id}).get(0);
    }

    /**
     * 获取该课程的所有课程图片ID
     *
     * @param productId
     * @return
     */
    @Override
    public List<String> findProductImgIdByProductId(String productId) {
        if (StringUtils.isNotBlank(productId)) {
            String hql = "select id from " + ProductImage.class.getName() + " where productId = ?";
            return hibernateTemplate.find(hql, new Object[]{productId});
        }
        return null;
    }

    /**
     * 根据字典类型获取字典
     *
     * @param dicType
     * @return
     */
    @Override
    public List<Dic> findDicListByDicType(String dicType) {
        if (StringUtils.isNotBlank(dicType)) {
            String hql = "from " + Dic.class.getName() + " dic where dic.dicComponent.dicType = ?";
            return hibernateTemplate.find(hql, new Object[]{dicType});
        }
        return null;
    }

    /**
     * 根据Id获取产品详情图片
     *
     * @param id
     * @return
     */
    @Override
    public byte[] takeProductDatailImg(String id) {
        String hql = "select productDetailImg from " + ProductDetailImg.class.getName() + " where id = ?";
        return (byte[])hibernateTemplate.find(hql,new Object[]{id}).get(0);
    }

    /**
     * 根据Id获取产品精彩图片
     *
     * @param id
     * @return
     */
    @Override
    public byte[] takeProductGreateImg(String id) {
        String hql = "select greatImg from " + ProductGreateImg.class.getName() + " where id = ?";
        return (byte[])hibernateTemplate.find(hql,new Object[]{id}).get(0);
    }

    /**
     * 获取该课程的所有课程详情图片ID
     *
     * @param productId
     * @return
     */
    @Override
    public List<String> findProductDetailImgIdByProductId(String productId) {
        if (StringUtils.isNotBlank(productId)) {
            String hql = "select id from " + ProductDetailImg.class.getSimpleName() + " where productId = ?";
            return hibernateTemplate.find(hql, new Object[]{productId});
        }
        return null;
    }

    /**
     * 获取该课程的所有课程精彩截图图片ID
     *
     * @param productId
     * @return
     */
    @Override
    public List<String> findProductGreateImgIdByProductId(String productId) {
        if (StringUtils.isNotBlank(productId)) {
            String hql = "select id from " + ProductGreateImg.class.getSimpleName() + " where productId = ?";
            return hibernateTemplate.find(hql, new Object[]{productId});
        }
        return null;
    }

    /**
     * 获取所有产品等级集合
     *
     * @return
     */
    @Override
    public List<ProductLevel> findAllProductLevelList() {
        String hql = "from " + ProductLevel.class.getName();
        return hibernateTemplate.find(hql);
    }

    /**
     * 获取所有产品分类集合
     *
     * @return
     */
    @Override
    public List<ProductKind> findAllProductKindList() {
        String hql = "from " + ProductKind.class.getName();
        return hibernateTemplate.find(hql);
    }

    /**
     * 根据产品id获取产品缩略图
     *
     * @param productId
     * @return
     */
    @Override
    public byte[] takeProductHeadImg(String productId) {
        if (StringUtils.isNotBlank(productId) && productId != null) {
            //String hql = "select productImage from" + ProductImage.class.getSimpleName() + productImage"as " + " where productId = ?";

            // select productImage from ProductImage pi where pi.productId = ?
            String hql = "select productImage from " + ProductImage.class.getSimpleName() + " pi where pi.productId = ?";
            List byteList = hibernateTemplate.find(hql, productId);
            if (byteList != null && byteList.size() > 0) {
                return (byte[]) byteList.get(0);
            }

        }
        return null;
    }


    /**
     * 获取所有产品
     *
     * @return
     */
    @Override
    public List<Product> findAllProductList() {
        String hql = "from " + Product.class.getName();
        return hibernateTemplate.find(hql);
    }
}
