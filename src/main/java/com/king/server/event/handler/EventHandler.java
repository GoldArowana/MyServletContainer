package com.king.server.event.handler;

public interface EventHandler<T> {
    /**
     * 处理事件
     */
    void handle(T obj) throws HandlerException;
}
