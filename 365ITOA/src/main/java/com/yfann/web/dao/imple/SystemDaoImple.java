package com.yfann.web.dao.imple;

import com.yfann.web.dao.SystemDao;
import com.yfann.web.dao.common.imple.BaseDaoImple;
import com.yfann.web.model.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统Dao
 */
@Repository("systemDao")
public class SystemDaoImple extends BaseDaoImple<User> implements SystemDao<User> {

    /**
     * 登陆
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        if (user != null && StringUtils.isNotBlank(user.getUserId()) && StringUtils.isNotBlank(user.getPassword())){
            String hql = "from " + User.class.getName() + " where userId = ? and password = ?";
            List<User> userList = hibernateTemplate.find(hql, new Object[]{user.getUserId(), user.getPassword()});
            return userList.get(0);
        }
        return null;
    }
}
