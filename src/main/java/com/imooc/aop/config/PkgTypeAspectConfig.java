package com.imooc.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: com.imooc.aop.config
 * @description:
 * @author: 86138_town
 * @create date: 2022/4/4 14 43
 */
@Aspect
@Component
public class PkgTypeAspectConfig {

    @Pointcut("within(com.imooc.aop.service.ProductService)")//com.imooc.aop.service.sub.*
    public void matchType(){}


    @Before("matchType()")
    public void before() {
        System.out.println("");
        System.out.println("###before");
    }


}
