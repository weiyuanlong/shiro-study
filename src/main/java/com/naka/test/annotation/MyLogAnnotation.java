package com.naka.test.annotation;

import java.lang.annotation.*;

/**
 * @author ：yuanLong Wei
 * @date ：Created in 2019/4/23 17:00
 * @description：自定义日志注解
 * @modified By：
 * @version: 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLogAnnotation {

    String desc();

}
