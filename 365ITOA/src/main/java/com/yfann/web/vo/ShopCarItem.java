package com.yfann.web.vo;

import com.yfann.web.model.Product;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 购物车VO
 */
public class ShopCarItem implements Serializable {
    private String id;
    private Product product;
    private Integer count = 0;

    /*小计**/
    private BigDecimal subCount;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count += count;
    }

    /**
     * 小计
     * @return
     */
    public BigDecimal getSubCount() {
        return product.getProductPrice().multiply(new BigDecimal(count));
    }

    public void setSubCount(BigDecimal subCount) {
        this.subCount = subCount;
    }
}
