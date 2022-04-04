package com.imooc.aop.proxy;

import ch.qos.logback.core.net.server.Client;
import com.imooc.aop.proxy.cglib.DemoMethodInterceptor;
import com.imooc.aop.proxy.dynamic.jdkProxySubject;
import com.imooc.aop.proxy.staticpkg.ProxySubject;
import com.imooc.aop.proxy.staticpkg.RealSubject;
import com.imooc.aop.proxy.staticpkg.Subject;
import org.springframework.cglib.proxy.Enhancer;
//import com.sun.deploy.util.SessionState.Client;

import java.lang.reflect.Proxy;

/**
 * @program: com.imooc.aop.proxy
 * @description: JDK只能针对有接口的类的接口方法进行代理
 * Cglib基于继承来实现代理，无法对static，final类进行代理，
 * Cglib基于继承来实现代理，无法对private,static类进行代理，
 * @author: 86138_town
 * @create date: 2022/4/4 17 42
 */

public class TestDemo {
    public static void main(String[] args) {
        //动态代理
//        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(),
//                new Class[]{Subject.class}, new jdkProxySubject(new RealSubject()));
//        subject.request();
        //静态代理
//        ProxySubject proxySubject = new ProxySubject(new RealSubject());
//        proxySubject.request();
        //如果Subject接口加hello方法，那么ProxySubject和RealSubejct 也要重写hello()方法，
        // 而动态代理不会，所以动态代理更方便

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        Subject subject1 = (Subject) enhancer.create();
        subject1.request();

    }
}
