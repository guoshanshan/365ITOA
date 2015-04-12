package com.yfann.web.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by Simon on 2015/4/2.
 */
public class Product {
    private String id;
    private String productId;
    private String userId;
    private BigDecimal productPrice;
    private Date onlineTime;
    private Date offlineTime;
    private String cloudeUrl;
    private String cloudeCode;
    private String productDesc;
    private Date updateDate;
    private String status;
    private String productName;
    private String productIntroduction;

    /*课程详情图片**/
/*    private Set<ProducDetailImg> producDetailImgSet;
    *//*课程精彩**//*
    private Set<ProductGreateImg> productGreateImgSet;

    public Set<ProducDetailImg> getProducDetailImgSet() {
        return producDetailImgSet;
    }

    public void setProducDetailImgSet(Set<ProducDetailImg> producDetailImgSet) {
        this.producDetailImgSet = producDetailImgSet;
    }

    public Set<ProductGreateImg> getProductGreateImgSet() {
        return productGreateImgSet;
    }

    public void setProductGreateImgSet(Set<ProductGreateImg> productGreateImgSet) {
        this.productGreateImgSet = productGreateImgSet;
    }*/

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Date getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(Date offlineTime) {
        this.offlineTime = offlineTime;
    }

    public String getCloudeUrl() {
        return cloudeUrl;
    }

    public void setCloudeUrl(String cloudeUrl) {
        this.cloudeUrl = cloudeUrl;
    }

    public String getCloudeCode() {
        return cloudeCode;
    }

    public void setCloudeCode(String cloudeCode) {
        this.cloudeCode = cloudeCode;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (cloudeCode != null ? !cloudeCode.equals(product.cloudeCode) : product.cloudeCode != null) return false;
        if (cloudeUrl != null ? !cloudeUrl.equals(product.cloudeUrl) : product.cloudeUrl != null) return false;
        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (offlineTime != null ? !offlineTime.equals(product.offlineTime) : product.offlineTime != null) return false;
        if (onlineTime != null ? !onlineTime.equals(product.onlineTime) : product.onlineTime != null) return false;
        if (productDesc != null ? !productDesc.equals(product.productDesc) : product.productDesc != null) return false;
        if (productId != null ? !productId.equals(product.productId) : product.productId != null) return false;
        if (productPrice != null ? !productPrice.equals(product.productPrice) : product.productPrice != null)
            return false;
        if (status != null ? !status.equals(product.status) : product.status != null) return false;
        if (updateDate != null ? !updateDate.equals(product.updateDate) : product.updateDate != null) return false;
        if (userId != null ? !userId.equals(product.userId) : product.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (onlineTime != null ? onlineTime.hashCode() : 0);
        result = 31 * result + (offlineTime != null ? offlineTime.hashCode() : 0);
        result = 31 * result + (cloudeUrl != null ? cloudeUrl.hashCode() : 0);
        result = 31 * result + (cloudeCode != null ? cloudeCode.hashCode() : 0);
        result = 31 * result + (productDesc != null ? productDesc.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductIntroduction() {
        return productIntroduction;
    }

    public void setProductIntroduction(String productIntroduction) {
        this.productIntroduction = productIntroduction;
    }
}
