package com.naka.test.controller;

import com.naka.test.annotation.MyLogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：yuanLong Wei
 * @date ：Created in 2019/4/26 11:10
 * @description：授权管理控制器
 * @modified By：
 * @version: 1.0
 */
@Controller
@Slf4j
@RequestMapping("auth")
public class AuthController {

    @MyLogAnnotation(desc = "跳转登陆页面")
    @RequestMapping("login")
    public String login() {
        return "login";
    }

}
