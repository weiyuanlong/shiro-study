package com.naka.test.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：yuanLong Wei
 * @date ：Created in 2019/4/26 17:03
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
public class MySessionAdapter implements WebMvcConfigurer {

    private final MySessionInterceptor mySessionInterceptor;

    @Autowired
    public MySessionAdapter(MySessionInterceptor mySessionInterceptor) {
        this.mySessionInterceptor = mySessionInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mySessionInterceptor);
    }

}
