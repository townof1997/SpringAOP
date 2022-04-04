package com.imooc.aop.security;

import com.imooc.aop.service.AuthService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: springaop.com.imooc.aop.security
 * @description:
 * @author: 86138_town
 * @create date: 2022/3/30 22 56
 */
@Aspect//第一步定义一个Aspect类
@Component
public class SecurityAspect {

    @Autowired
    AuthService authService;

    @Pointcut("@annotation(AdminOnly)")//定义切哪些东西
    public void adminOnly() {

    }

    @Before("adminOnly()")//在执行带有AdminOnly的注解的Before执行
    public void check() {
        authService.checkService();
    }


}
