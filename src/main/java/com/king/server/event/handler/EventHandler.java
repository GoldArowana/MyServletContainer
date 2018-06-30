package com.king.server.event.handler;

public interface EventHandler<T> {
    /**
     * 处理事件
     * @param obj
     * @throws HandlerException
     */
    void handle(T obj) throws HandlerException;
}
