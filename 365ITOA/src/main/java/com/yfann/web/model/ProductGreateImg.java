package com.yfann.web.model;

import java.util.Arrays;

/**
 * Created by Simon on 2015/4/2.
 */
public class ProductGreateImg {
    private String id;
    private String productId;
    private byte[] greatImg;

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

    public byte[] getGreatImg() {
        return greatImg;
    }

    public void setGreatImg(byte[] greatImg) {
        this.greatImg = greatImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductGreateImg that = (ProductGreateImg) o;

        if (!Arrays.equals(greatImg, that.greatImg)) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (greatImg != null ? Arrays.hashCode(greatImg) : 0);
        return result;
    }
}
