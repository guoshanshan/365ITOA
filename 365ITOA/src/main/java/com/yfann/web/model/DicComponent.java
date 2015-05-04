package com.yfann.web.model;

import java.io.Serializable;

/**
 * Created by Simon on 2015/4/15.
 */
public class DicComponent implements Serializable{
    private String dicType;
    private String dicCode;

    public String getDicType() {
        return dicType;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType;
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DicComponent that = (DicComponent) o;

        if (!dicCode.equals(that.dicCode)) return false;
        if (!dicType.equals(that.dicType)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dicType.hashCode();
        result = 31 * result + dicCode.hashCode();
        return result;
    }
}
