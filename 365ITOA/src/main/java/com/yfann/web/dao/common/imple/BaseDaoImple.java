package com.yfann.web.dao.common.imple;

import com.yfann.web.dao.common.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

/**
 * 通用DAO
 */
public class BaseDaoImple<T> implements BaseDao<T>{
    @Autowired
    protected HibernateTemplate hibernateTemplate;
    /*实体字节码**/
    private Class<T> modelClass;
    public BaseDaoImple(){
        //获取泛型参数类型
        ParameterizedType parameterizedType = (ParameterizedType)getClass().getGenericSuperclass();
        modelClass = (Class)parameterizedType.getActualTypeArguments()[0];
    }
    /**
     * 保存实体
     *
     * @param model
     */
    @Override
    public void saveModel(T model) {
            hibernateTemplate.save(model);
    }

    /**
     * 删除实体
     *
     * @param modelId
     */
    @Override
    public void deleteModel(Serializable modelId) {
        hibernateTemplate.delete(this.findModelById(modelId));
    }

    /**
     * 更新实体
     *
     * @param model
     */
    @Override
    public void updateModel(T model) {
        hibernateTemplate.update(model);

    }

    /**
     * 根据id查找实体
     *
     * @param id
     * @return
     */
    @Override
    public T findModelById(Serializable id) {
        return hibernateTemplate.get(modelClass,id);
    }

    /**
     * 获取所有实体对象
     *
     * @return
     */
    @Override
    public Collection<T> findAllModel() {
        return hibernateTemplate.find("from " + modelClass.getName());
    }

    /**
     * 根据id加载懒实体
     *
     * @param id
     * @return
     */
    @Override
    public T findLazyModelById(Serializable id) {
        return hibernateTemplate.load(modelClass,id);
    }

    /**
     * 获取所有懒实体
     *
     * @return
     */
    @Override
    public Collection<T> findAllLazyModel() {
        return hibernateTemplate.loadAll(modelClass);
    }
}
