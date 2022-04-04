package com.imooc.aop.proxy.chain;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @program: com.imooc.aop.proxy.chain
 * @description:
 * @author: 86138_town
 * @create date: 2022/4/4 18 44
 */

public class ChainClient {
    static class ChainHandlerA extends ChainHandler{

        @Override
        protected void handleProcess() {
            System.out.println("HandlerA的handleProcess");
        }
    }

    static class ChainHandlerB extends ChainHandler{

        @Override
        protected void handleProcess() {
            System.out.println("HandlerB的handleProcess");
        }
    }

    static class ChainHandlerC extends ChainHandler{

        @Override
        protected void handleProcess() {
            System.out.println("HandlerC的handleProcess");
        }
    }

    public static void main(String[] args) {
        List<ChainHandler> handlers = Arrays.asList(
                new ChainHandlerA(),
                new ChainHandlerB(),
                new ChainHandlerC()
        );
        Chain chain = new Chain(handlers);
        chain.proceed();

    }
}
