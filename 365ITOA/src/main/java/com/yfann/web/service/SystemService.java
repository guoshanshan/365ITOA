package com.yfann.web.service;

import com.yfann.web.model.User;

/**
 * Created by Simon on 2015/4/1.
 */
public interface SystemService {
    /**
     * 注册
     * @param user
     */
    public void regist(User user);
    /**
     * 登陆
     * @param user
     * @return
     */
    public User login(User user);
}
