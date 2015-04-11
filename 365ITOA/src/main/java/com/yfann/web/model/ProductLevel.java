package com.yfann.web.model;

/**
 * Created by Simon on 2015/4/4.
 */
public class ProductLevel {
    private String id;
    private String levelName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductLevel that = (ProductLevel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (levelName != null ? !levelName.equals(that.levelName) : that.levelName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (levelName != null ? levelName.hashCode() : 0);
        return result;
    }
}
