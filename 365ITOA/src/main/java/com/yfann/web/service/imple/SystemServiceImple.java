package com.yfann.web.service.imple;

import com.yfann.web.dao.SystemDao;
import com.yfann.web.model.User;
import com.yfann.web.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统Service
 */
@Service("systemService")
public class SystemServiceImple implements SystemService{
    @Autowired
    private SystemDao systemDao;

    /**
     * 注册
     *
     * @param user
     */
    @Override
    public void regist(User user) {
        systemDao.saveModel(user);
    }

    /**
     * 登陆
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return systemDao.login(user);
    }
}
