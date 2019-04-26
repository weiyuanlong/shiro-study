package com.naka.test.aspects;

import com.naka.test.annotation.MyLogAnnotation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ：yuanLong Wei
 * @date ：Created in 2019/4/23 17:04
 * @description：日志切面输出
 * @modified By：
 * @version: 1.0
 */
@Component
@Aspect
@Slf4j
public class LogPrintAspect {

    @Pointcut("@annotation(com.naka.test.annotation.MyLogAnnotation)")
    private void controllerAspect() {

    }

    @Before("controllerAspect() && @annotation(desc)")
    public void beforePrintLog(JoinPoint point, MyLogAnnotation desc) {
        // log.info("beforePrintLog执行了，注解参数为：{}，参数列表为：{}",desc.desc(),point.getArgs());
    }

    @SneakyThrows
    @Around("controllerAspect() && @annotation(desc)")
    public Object aroundPrintLog(ProceedingJoinPoint point, MyLogAnnotation desc) {
        log.info("{}；参数列表为：{}",desc.desc(),point.getArgs());
        Object proceed = point.proceed();
        log.info("{} 返回结果为： {}", desc.desc(), proceed);
        return proceed;
    }

}
