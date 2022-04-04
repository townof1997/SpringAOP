package com.imooc.aop.proxy.staticpkg;

/**
 * @program: proxy
 * @description:
 * @author: 86138_town
 * @create date: 2022/3/30 11 01
 */

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject");
    }
}
