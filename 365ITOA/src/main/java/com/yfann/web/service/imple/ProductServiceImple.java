package com.yfann.web.service.imple;

import com.yfann.web.dao.ProductDao;
import com.yfann.web.model.Product;
import com.yfann.web.model.ProductKind;
import com.yfann.web.model.ProductLevel;
import com.yfann.web.service.ProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Simon on 2015/4/2.
 */
@Service("productService")
public class ProductServiceImple implements ProductService {
    @Autowired
    private ProductDao productDao;

    /**
     * 根据id获取产品详情图片
     *
     * @param id
     * @return
     */
    @Override
    public byte[] takeProductDatailImg(String id) {
        return productDao.takeProductDatailImg(id);
    }

    /**
     * 根据Id获取产品精彩图片
     *
     * @param id
     * @return
     */
    @Override
    public byte[] takeProductGreateImg(String id) {
        return productDao.takeProductGreateImg(id);
    }

    /**
     * 获取该课程的所有课程详情图片ID
     *
     * @param productId
     * @return
     */
    @Override
    public List<String> findProductDetailImgIdByProductId(String productId) {
        return productDao.findProductDetailImgIdByProductId(productId);
    }

    /**
     * 获取该课程的所有课程精彩截图图片ID
     *
     * @param productId
     * @return
     */
    @Override
    public List<String> findProductGreateImgIdByProductId(String productId) {
        return productDao.findProductGreateImgIdByProductId(productId);
    }

    /**
     * 获取所有产品等级集合
     *
     * @return
     */
    @Override
    public List<ProductLevel> findAllProductLevelList() {
        return productDao.findAllProductLevelList();
    }

    /**
     * 获取所有产品分类集合
     *
     * @return
     */
    @Override
    public List<ProductKind> findAllProductKindList() {
        return productDao.findAllProductKindList();
    }

    /**
     * 根据产品id获取产品缩略图
     *
     * @param productId
     * @return
     */
    @Override
    public byte[] takeProductHeadImg(String productId) {
        if (StringUtils.isNotBlank(productId) && productId != null){
            return productDao.takeProductHeadImg(productId);
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
        return productDao.findAllProductList();
    }

    /**
     * 获取产品
     * @param product
     * @return
     */
    @Override
    public Product findProduct(Product product) {
        if (product != null && StringUtils.isNotBlank(product.getId())){
            return (Product)productDao.findModelById(product.getId());
        }
        return null;
    }
}
