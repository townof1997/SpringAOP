package com.imooc.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: com.imooc.aop.config
 * @description:
 * @author: 86138_town
 * @create date: 2022/4/4 16 29
 */
@Aspect
@Component
public class ExecutionAspectConfig {

//    @Pointcut("execution(public * com.imooc.aop.service..*Service.*(..))")
//    @Pointcut("execution(public * com.imooc.aop.service..*Service.*())")//拦截无参的
//    @Pointcut("execution(public * com.imooc.aop.service..*Service.*(Long))")
    @Pointcut("execution(public * com.imooc.aop.service..*Service.*(..) throws java.lang.IllegalAccessException)")
    public void matchCondition(){}

    @Before("matchCondition()")
    public void before() {
        System.out.println("1111");
        System.out.println("###before");
    }
}

   