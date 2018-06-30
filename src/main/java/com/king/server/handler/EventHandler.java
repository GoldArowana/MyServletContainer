package com.king.server.handler;

public interface EventHandler<T> {
    void handle(T obj) throws HandlerException;
}
