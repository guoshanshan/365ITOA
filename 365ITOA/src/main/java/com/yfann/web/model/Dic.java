package com.yfann.web.model;

/**
 * Created by Simon on 2015/4/6.
 */
public class Dic {
    private String id;
    private String dicType;
    private String dicCn;
    private String dicCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDicType() {
        return dicType;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType;
    }

    public String getDicCn() {
        return dicCn;
    }

    public void setDicCn(String dicCn) {
        this.dicCn = dicCn;
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

        Dic dic = (Dic) o;

        if (dicCn != null ? !dicCn.equals(dic.dicCn) : dic.dicCn != null) return false;
        if (dicCode != null ? !dicCode.equals(dic.dicCode) : dic.dicCode != null) return false;
        if (dicType != null ? !dicType.equals(dic.dicType) : dic.dicType != null) return false;
        if (id != null ? !id.equals(dic.id) : dic.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dicType != null ? dicType.hashCode() : 0);
        result = 31 * result + (dicCn != null ? dicCn.hashCode() : 0);
        result = 31 * result + (dicCode != null ? dicCode.hashCode() : 0);
        return result;
    }
}
