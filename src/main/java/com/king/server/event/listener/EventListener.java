package com.king.server.event.listener;

import com.king.server.event.EventException;

public interface EventListener<T> {

    void onEvent(T event) throws EventException;
}
