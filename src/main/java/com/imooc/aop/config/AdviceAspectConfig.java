package com.imooc.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: com.imooc.aop.config
 * @description:
 * @author: 86138_town
 * @create date: 2022/4/4 16 52
 */
@Aspect
@Component
public class AdviceAspectConfig {

    @Pointcut("@annotation(com.imooc.aop.security.AdminOnly) && within(com.imooc..*)")
    public void matchAnno(){}

    @Pointcut("execution(* *..find*(Long)) && within(com.imooc..*) ")
    public void matchLongArg(){}

    @Pointcut("execution(public * com.imooc.aop.service..*Service.*(..) " +
            "throws java.lang.IllegalAccessException) && within(com.imooc..*)")
    public void matchException(){}

    @Pointcut("execution(String com.imooc..*.*(..)) && within(com.imooc..*)")
    public void matchReturn(){}

    @Pointcut("@within(com.imooc.aop.security.NeedSecured)")
    public void annoTargetVsWithinDemo(){}

    /*************advice***************/

    @Before("annoTargetVsWithinDemo() && within(com.imooc.aop..*)")
    public void demo(){
        System.out.println("#############Before Demo......");
        throw new RuntimeException("do not proceed");
    }

    @Before("annoTargetVsWithinDemo() && within(com.imooc.aop..*) && args(userId)")
    public void demo2(JoinPoint joinPoint, Long userId){
        System.out.println("#############Before Demo......" + userId);
    }

    @After("annoTargetVsWithinDemo() && within(com.imooc.aop..*)")
    public void afterDemo() {
        System.out.println("#############afterDemo aop by within");
    }

    @AfterReturning("annoTargetVsWithinDemo() && within(com.imooc.aop..*)")
    public void afterReturnDemo() {
        System.out.println("#############afterReturnDemo aop by within");
    }

    @AfterReturning(value = "annoTargetVsWithinDemo() && within(com.imooc.aop..*)", returning = "returnValue")
    public void afterReturnDemo2(Object returnValue) {
        if (returnValue != null)
            System.out.println("#############afterReturnDemo aop by within" + returnValue);
    }

    @AfterThrowing("annoTargetVsWithinDemo() && within(com.imooc.aop..*)")
    public void afterThrowDemo() {
        System.out.println("#############afterThrowDemo aop by within");
    }

    @Around("annoTargetVsWithinDemo() && within(com.imooc.aop..*)")
    public Object aroundDemo(ProceedingJoinPoint pjp) {
        Object result = null;
        try {
            result = pjp.proceed(pjp.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println("#############aroundDemo aop by within");
        }
        return result;
    }

    @Before("matchLongArg() && args(productId)")
    public void before(Long productId) {
        System.out.println("before ,get args: " +productId);
    }

//    @After("matchAnno()")
    @After("matchException()")
//    @AfterThrowing("matchException()")
//    @AfterReturning(value = "matchReturn()", returning = "result")
    public void after(){
        System.out.println("###after");
    }

    @AfterReturning(value = "matchReturn()", returning = "result")
//    @Around()
    public void after(java.lang.Object result){
        System.out.println("###after" + result.toString());
    }

    @Around(value = "matchAnno()")
    public java.lang.Object after(ProceedingJoinPoint point){
        java.lang.Object result = null;
        try{
            result = point.proceed(point.getArgs());
            System.out.println("try");
        } catch (Throwable e) {

            System.out.println("####ex");
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
        return result;
    }


}
