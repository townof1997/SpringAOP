package com.imooc.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: com.imooc.aop.config
 * @description:
 * @author: 86138_town
 * @create date: 2022/4/4 15 43
 */
@Aspect
@Component
public class AnnoAspectConfig {

//    @Pointcut("@annotation(com.imooc.aop.anno.AdminOnly)")
//    @Pointcut("@annotation(com.imooc.aop.security.NeedSecured)")
//    @Pointcut("@target(com.imooc.aop.security.NeedSecured) && within(com.imooc..*)")
    @Pointcut("@args(com.imooc.aop.security.NeedSecured) && within(com.imooc..*)")
    public void matchAnno() {
    }
    @Before("matchAnno()")
    public void before() {
        System.out.println("");
        System.out.println("###before");
    }


    //匹配方法标注有AdminOnly的注解的方法
//    @Pointcut("@annotation(com.imooc.aop.demo.security.AdminOnly)")
//    public void annoDemo() {
//    }
//    //匹配标注有Beta的类底下的方法，要求的annotation的RetentionPolicy级别的CLASS
//    @Pointcut("@within(com.google.common.annotations.Beta)")
//    public void annoWithinDemo() {
//    }

    //匹配标注有Repository的类底下的方法，要求的annotation的RetentionPolicy级别的RUNTIME
    @Pointcut("@target(org.springframework.stereotype.Repository)")
    public void annoTargetDemo() {}

    //匹配传入的参数类标注有RetentionPolicy注解的方法
    @Pointcut("@args(org.springframework.stereotype.Repository)")
    public void annoArgsDemo() {}
}

   