package com.king.server.event.handler;


public interface EventHandler<T> {
    void handle(T obj) throws HandlerException;
}
