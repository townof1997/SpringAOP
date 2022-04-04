package com.imooc.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: com.imooc.aop.config
 * @description:
 * @author: 86138_town
 * @create date: 2022/4/4 15 08
 */
@Aspect
@Component
public class ObjectAspectConfig {

    /*匹配参数*/

    /*
    //匹配AOP对象的目标对象为指定类型的方法，即DemoDao的aop代理对象的方法
    @Pointcut("this(com.imooc.aop.DemoDao)")
    public void thisDemo() {
    }
    //匹配实现IDao接口的目标对象(而不是aop代理后的对象)的方法，这里即DemoDao方法
    @Pointcut("target(com.imooc.aop.IDao)")
    public void targetDemo() {
    }
    //匹配所有以Service结尾的bean里头的方法
    @Pointcut("bean(*Service)")
    public void beanDemo() {}*/

    //对象匹配
    @Pointcut("this(com.imooc.aop.log.Loggable)")
    //@Pointcut("target(com.imooc.aop.log.Loggable)")
//    @Pointcut("bean(logService)")
    public void matchCondition(){}

    @Before("matchCondition()")
    public void before() {
        System.out.println("");
        System.out.println("###before");
    }
}

   