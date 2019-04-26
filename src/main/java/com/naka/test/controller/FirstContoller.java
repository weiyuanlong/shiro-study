package com.naka.test.controller;

import com.naka.test.annotation.MyLogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：yuanLong Wei
 * @date ：Created in 2019/4/23 16:21
 * @description：测试第一个前端控制器
 * @modified By：
 * @version: 1.0
 */
@Controller
@RequestMapping("first")
@Slf4j
public class FirstContoller {

    @RequestMapping("firstRequest")
    @MyLogAnnotation(desc = "测试注解")
    @ResponseBody
    public String firstRequest(String param) {
        log.info("参数为：{}",param);
        return "请求参数为：" + param;
    }

    @RequestMapping("index")
    public String findIndex() {
        log.info("findIndex");
        return "index";
    }

}
