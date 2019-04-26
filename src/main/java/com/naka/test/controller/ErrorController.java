package com.naka.test.controller;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：yuanLong Wei
 * @date ：Created in 2019/4/26 14:13
 * @description：错误管理控制器
 * @modified By：
 * @version: 1.0
 */
@Controller
public class ErrorController {

    @RequestMapping("noAuth")
    public String noAuth() {
        return "error/noAuth";
    }

    @RequestMapping("404")
    public String error404() {
        return "error/404";
    }

    @RequestMapping("500")
    public String error500() {
        return "error/500";
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return (container -> {
            ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
            container.addErrorPages(error404,error500Page);
        });
    }

}
