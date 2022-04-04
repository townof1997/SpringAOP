package com.imooc.aop.proxy.chain;

/**
 * @program: com.imooc.aop.proxy.chain
 * @description:
 * @author: 86138_town
 * @create date: 2022/4/4 18 39
 */

public abstract class ChainHandler {

    public void execute(Chain chain) {
        handleProcess();
        chain.proceed();
    }
    protected abstract void handleProcess();
}

   