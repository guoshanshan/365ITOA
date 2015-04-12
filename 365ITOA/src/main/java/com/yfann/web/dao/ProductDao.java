package com.yfann.web.dao;

import com.yfann.web.dao.common.BaseDao;
import com.yfann.web.model.*;

import java.util.List;

/**
 * Created by Simon on 2015/4/2.
 */
public interface ProductDao<T> extends BaseDao<T> {

    /**
     * 获取课程图片
     * @param id
     * @return
     */
    public byte[] takeProductImg(String id);

    /**
     * 获取该课程的所有课程图片ID
     * @param productId
     * @return
     */
    public List<String> findProductImgIdByProductId(String productId);

    /**
     * 根据字典类型获取字典
     *
     * @param dicType
     * @return
     */
    public List<Dic> findDicListByDicType(String dicType);

    /**
     * 根据Id获取产品详情图片
     * @param id
     * @return
     */
    public byte[] takeProductDatailImg(String id);

    /**
     * 根据Id获取产品精彩图片
     * @param id
     * @return
     */
    public byte[] takeProductGreateImg(String id);

    /**
     * 获取该课程的所有课程详情图片ID
     * @param productId
     * @return
     */
    public List<String> findProductDetailImgIdByProductId(String productId);

    /**
     * 获取该课程的所有课程精彩截图图片ID
     * @param productId
     * @return
     */
    public List<String> findProductGreateImgIdByProductId(String productId);

    /**
     * 获取所有产品等级集合
     * @return
     */
    public List<ProductLevel> findAllProductLevelList();

    /**
     * 获取所有产品分类集合
     * @return
     */
    public List<ProductKind> findAllProductKindList();
    /**
     * 根据产品id获取产品缩略图
     * @param productId
     * @return
     */
    public byte[] takeProductHeadImg(String productId);


    /**
     * 获取所有产品
     * @return
     */
    public List<Product> findAllProductList();
}
