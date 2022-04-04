package com.imooc.aop.proxy.dynamic;


import com.imooc.aop.proxy.staticpkg.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: proxy.dynamic
 * @description:
 * @author: 86138_town
 * @create date: 2022/3/30 11 59
 */

public class jdkProxySubject implements InvocationHandler {

    private RealSubject realSubject;

    public jdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = null;
        try {
            result = method.invoke(realSubject, args);

        } catch(Exception e) {
            System.out.println("e: " + e.getMessage());
            throw e;

        } finally {
            System.out.println("after");
        }
        return result;
    }
}
