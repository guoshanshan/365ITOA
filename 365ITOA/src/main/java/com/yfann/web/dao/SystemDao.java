package com.yfann.web.dao;

import com.yfann.web.dao.common.BaseDao;
import com.yfann.web.model.User;

/**
 * 系统Dao
 */
public interface SystemDao<T> extends BaseDao<T> {
    /**
     * 登陆
     * @param user
     * @return
     */
    public User login(User user);
}
