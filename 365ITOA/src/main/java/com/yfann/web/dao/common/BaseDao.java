package com.yfann.web.dao.common;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Simon on 2015/4/1.
 */
public interface BaseDao<T> {
    /**
     * 保存实体
     * @param model
     */
    public void saveModel(T model);

    /**
     * 删除实体
     * @param modelId
     */
    public void deleteModel(Serializable modelId);

    /**
     * 更新实体
     * @param model
     */
    public void updateModel(T model);

    /**
     * 根据id查找实体
     * @param id
     * @return
     */
    public T findModelById(Serializable id);

    /**
     * 根据id加载懒实体
     * @param id
     * @return
     */
    public T findLazyModelById(Serializable id);

    /**
     * 获取所有实体对象
     * @return
     */
    public Collection<T> findAllModel();

    /**
     * 获取所有懒实体
     * @return
     */
    public Collection<T> findAllLazyModel();
}
