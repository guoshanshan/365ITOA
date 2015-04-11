package com.yfann.web.vo;

import java.io.Serializable;

/**
 * Created by Simon on 2015/4/4.
 */
public class User implements Serializable {
    public String userId;
    public String password;
    public String rePassword;
    public String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
