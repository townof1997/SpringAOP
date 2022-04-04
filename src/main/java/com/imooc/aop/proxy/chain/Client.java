package com.imooc.aop.proxy.chain;

/**
 * @program: com.imooc.aop.proxy.chain
 * @description:
 * @author: 86138_town
 * @create date: 2022/4/4 18 35
 */

public class Client {
    static class HandlerA extends Handler{

        @Override
        protected void handleProcess() {
            System.out.println("HandlerA的handleProcess");
        }
    }

    static class HandlerB extends Handler{

        @Override
        protected void handleProcess() {
            System.out.println("HandlerB的handleProcess");
        }
    }

    static class HandlerC extends Handler{

        @Override
        protected void handleProcess() {
            System.out.println("HandlerC的handleProcess");
        }
    }

    public static void main(String[] args) {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();

        handlerA.setHandler(handlerB);
        handlerB.setHandler(handlerC);

        handlerA.execute();
    }
}
