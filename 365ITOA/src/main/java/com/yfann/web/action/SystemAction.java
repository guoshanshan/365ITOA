package com.yfann.web.action;

import com.yfann.web.model.User;
import com.yfann.web.service.SystemService;
import com.yfann.web.utils.UUIDCreate;
import com.yfann.web.vo.ApplicationValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统控制器
 */
@Controller
@RequestMapping("/system")
public class SystemAction {
    private final String action_pri = "/system";
    @Autowired
    private SystemService systemService;

    /**
     * 注册
     * @param userVo
     * @return
     */
    @RequestMapping("regist")
    public String regist(com.yfann.web.vo.User userVo){
        if (userVo != null){
            if (userVo.getPassword().equals(userVo.getRePassword())){
                User user = new User();
                user.setId(UUIDCreate.takeUUID());
                user.setUserId(userVo.getUserId());
                user.setPassword(userVo.getPassword());
                user.setEmail(userVo.getEmail());
                systemService.regist(user);
            }
        }
        return "redirect:" + action_pri + "/forwardLogin" + ApplicationValue.APP_LAST_NAME;
    }


    /**
     * 用户退出
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        //清楚登陆信息
        request.getSession().setAttribute(ApplicationValue.SESSION_USER,null);
        return "redirect:" + action_pri + "/forwardIndex" + ApplicationValue.APP_LAST_NAME;
    }

    /**
     * 跳转到主页
     *
     * @return
     */
    @RequestMapping("/forwardIndex")
    public String forwardIndex() {
        return "shop/index";
    }


    /**
     * 跳转到登陆界面
     *
     * @return
     */
    @RequestMapping("/forwardLogin")
    public String forwardLogin() {
        return "shop/login";
    }

    /**
     * 跳转到注册页面
     *
     * @return
     */
    @RequestMapping("/forwardRegist")
    public String forwardRegist() {
        return "shop/regist";
    }

    /**
     * 登陆功能
     *
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        User userInfo = systemService.login(user);
        request.getSession(true).setAttribute(ApplicationValue.SESSION_USER, userInfo);
        return "redirect:" + action_pri + "/forwardIndex" + ApplicationValue.APP_LAST_NAME;
    }

}
