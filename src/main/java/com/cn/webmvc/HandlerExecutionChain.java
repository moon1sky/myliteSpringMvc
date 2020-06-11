package com.cn.webmvc;

public class HandlerExecutionChain {

    private Object handler;

    public HandlerExecutionChain(Object handler){
        this.handler = handler;
    }

    public Object getHandler() {
        return this.handler;
    }
}
