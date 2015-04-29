package com.yfann.web.model;

import java.util.Arrays;

/**
 * Created by Simon on 2015/4/12.
 */
public class ProductDetailImg {
    private String id;
    private String productId;
    private byte[] productDetailImg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public byte[] getProductDetailImg() {
        return productDetailImg;
    }

    public void setProductDetailImg(byte[] productDetailImg) {
        this.productDetailImg = productDetailImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductDetailImg that = (ProductDetailImg) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!Arrays.equals(productDetailImg, that.productDetailImg)) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productDetailImg != null ? Arrays.hashCode(productDetailImg) : 0);
        return result;
    }
}
