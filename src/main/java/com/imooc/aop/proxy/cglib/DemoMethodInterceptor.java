package com.imooc.aop.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: com.imooc.aop.proxy.cglib
 * @description:
 * @author: 86138_town
 * @create date: 2022/4/4 17 53
 */

public class DemoMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before in cglib");
        Object result = null;
        try {
            result = methodProxy.invokeSuper(o, objects);

        } catch (Exception e) {
            System.out.println("get ex: " + e.getMessage());

            throw  e;
        } finally {
            System.out.println("after in cglib");
        }
        return result;
    }
}

   