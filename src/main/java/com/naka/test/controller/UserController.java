package com.naka.test.controller;

import com.alibaba.fastjson.JSON;
import com.naka.test.annotation.MyLogAnnotation;
import com.naka.test.domain.entity.User;
import com.naka.test.domain.model.LoginParam;
import com.naka.test.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ：yuanLong Wei
 * @date ：Created in 2019/4/25 10:43
 * @description：用户前端控制器
 * @modified By：
 * @version: 1.0
 */
@Controller
@Slf4j
@RequestMapping("user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("userList")
    @ResponseBody
    public String findAllUser() {
        List<User> list = userService.list();
        return JSON.toJSONString(list);
    }

    @MyLogAnnotation(desc = "userIndex 跳转用户首页")
    @RequestMapping("userIndex")
    public String userIndex() {
        return "userIndex";
    }

    @RequestMapping("login")
    @MyLogAnnotation(desc = "登陆验证")
    public String login(LoginParam loginParam) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginParam.getUsername(), loginParam.getPassword(), loginParam.isRememberMe());

        try {
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException e) {
            log.info("UnknownAccountException -- > 账号不存在：");
        } catch (IncorrectCredentialsException e) {
            log.info("IncorrectCredentialsException -- > 密码不正确：");
        } catch (LockedAccountException e) {
            log.info("LockedAccountException -- > 账号被锁定");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return "index";
    }

}
