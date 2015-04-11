package com.yfann.web.model;

import java.sql.Date;

/**
 * Created by Simon on 2015/4/2.
 */
public class MyProduct {
    private String id;
    private String userId;
    private String productId;
    private String smartCode;
    private String playerCode;
    private String authorizeStatus;
    private Date aceptDate;
    private Date authorizeDate;
    private String authorizeUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSmartCode() {
        return smartCode;
    }

    public void setSmartCode(String smartCode) {
        this.smartCode = smartCode;
    }

    public String getPlayerCode() {
        return playerCode;
    }

    public void setPlayerCode(String playerCode) {
        this.playerCode = playerCode;
    }

    public String getAuthorizeStatus() {
        return authorizeStatus;
    }

    public void setAuthorizeStatus(String authorizeStatus) {
        this.authorizeStatus = authorizeStatus;
    }

    public Date getAceptDate() {
        return aceptDate;
    }

    public void setAceptDate(Date aceptDate) {
        this.aceptDate = aceptDate;
    }

    public Date getAuthorizeDate() {
        return authorizeDate;
    }

    public void setAuthorizeDate(Date authorizeDate) {
        this.authorizeDate = authorizeDate;
    }

    public String getAuthorizeUser() {
        return authorizeUser;
    }

    public void setAuthorizeUser(String authorizeUser) {
        this.authorizeUser = authorizeUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyProduct myProduct = (MyProduct) o;

        if (aceptDate != null ? !aceptDate.equals(myProduct.aceptDate) : myProduct.aceptDate != null) return false;
        if (authorizeDate != null ? !authorizeDate.equals(myProduct.authorizeDate) : myProduct.authorizeDate != null)
            return false;
        if (authorizeStatus != null ? !authorizeStatus.equals(myProduct.authorizeStatus) : myProduct.authorizeStatus != null)
            return false;
        if (authorizeUser != null ? !authorizeUser.equals(myProduct.authorizeUser) : myProduct.authorizeUser != null)
            return false;
        if (id != null ? !id.equals(myProduct.id) : myProduct.id != null) return false;
        if (playerCode != null ? !playerCode.equals(myProduct.playerCode) : myProduct.playerCode != null) return false;
        if (productId != null ? !productId.equals(myProduct.productId) : myProduct.productId != null) return false;
        if (smartCode != null ? !smartCode.equals(myProduct.smartCode) : myProduct.smartCode != null) return false;
        if (userId != null ? !userId.equals(myProduct.userId) : myProduct.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (smartCode != null ? smartCode.hashCode() : 0);
        result = 31 * result + (playerCode != null ? playerCode.hashCode() : 0);
        result = 31 * result + (authorizeStatus != null ? authorizeStatus.hashCode() : 0);
        result = 31 * result + (aceptDate != null ? aceptDate.hashCode() : 0);
        result = 31 * result + (authorizeDate != null ? authorizeDate.hashCode() : 0);
        result = 31 * result + (authorizeUser != null ? authorizeUser.hashCode() : 0);
        return result;
    }
}
