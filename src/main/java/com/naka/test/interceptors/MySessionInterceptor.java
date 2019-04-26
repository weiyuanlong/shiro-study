package com.naka.test.interceptors;

import com.naka.test.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：yuanLong Wei
 * @date ：Created in 2019/4/26 15:49
 * @description：添加用户sessin拦截器
 * @modified By：
 * @version: 1.0
 */
@Slf4j
@Component
public class MySessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("UserInterceptor --> preHandle");
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        request.getSession().setAttribute("user",user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
