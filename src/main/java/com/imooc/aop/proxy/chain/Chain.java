package com.imooc.aop.proxy.chain;

import java.util.List;

/**
 * @program: com.imooc.aop.proxy.chain
 * @description: 封装调用关系 =
 * Handler handlerA = new HandlerA();
 *         Handler handlerB = new HandlerB();
 *         Handler handlerC = new HandlerC();
 *
 *         handlerA.setHandler(handlerB);
 *         handlerB.setHandler(handlerC);
 * @author: 86138_town
 * @create date: 2022/4/4 18 39
 */
public class Chain {
    private List<ChainHandler> handlers;
    private int index = 0;

    public Chain(List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    public void proceed() {
        if (index >= handlers.size()) {
            return;
        }
        handlers.get(index++).execute(this);
//        if (index < handlers.size() - 1) {
//
//        }

    }
}

   