package com.king.server.event;

public interface EventListener<T> {
    void onEvent(T event) throws EventException;
}