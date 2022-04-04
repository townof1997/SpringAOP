package com.imooc.aop.proxy.chain;

/**
 * @program: com.imooc.aop.proxy.chain
 * @description:
 * @author: 86138_town
 * @create date: 2022/4/4 18 32
 */

public abstract class Handler {
    private Handler sucessor;

    public Handler getHandler() {
        return sucessor;
    }

    public void setHandler(Handler sucessor) {
        this.sucessor = sucessor;
    }

    public void execute() {
        handleProcess();
        if (sucessor != null)
            sucessor.execute();

    }

    protected abstract void handleProcess();
}
