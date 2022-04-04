package com.imooc.aop.proxy.staticpkg;

/**
 * @program: proxy
 * @description:
 * @author: 86138_town
 * @create date: 2022/3/30 11 56
 */

public class ProxySubject implements Subject {
    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("ProxySubject");
        subject.request();
        System.out.println("after");
    }
}

   