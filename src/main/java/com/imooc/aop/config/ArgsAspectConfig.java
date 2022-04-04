package com.imooc.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: com.imooc.aop.config
 * @description:
 * @author: 86138_town
 * @create date: 2022/4/4 15 29
 */
@Aspect
@Component
public class ArgsAspectConfig {

    //匹配任何以find开头而且只有一个Long参数的方法
    @Pointcut("execution(* *..find*(Long))")
    public void argDemo1() {
    }
    //匹配只有一个Long参数的方法
    @Pointcut("args(Long)")
    public void argDemo2() {
    }
    //匹配任何以find开头而且第一个参数为Long的方法
    @Pointcut("execution(* *..find*(Long,..))")
    public void argDemo3() {}
    //匹配第一个参数为Long的方法
    @Pointcut("args(Long,..)")
    public void argDemo4() {}

    //匹配第一个参数为Long的方法
    @Pointcut("args(Long) && within(com.imooc.aop.service.*)")
//    @Pointcut("args(Long,String) && within(com.imooc.aop.service.*)")
    public void matchArgs() {
    }

    @Before("matchArgs()")
    public void before() {
        System.out.println("");
        System.out.println("###before");
    }



}

   