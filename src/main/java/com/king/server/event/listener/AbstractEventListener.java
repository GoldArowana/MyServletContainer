package com.king.server.event.listener;

import com.king.server.event.EventException;
import com.king.server.event.handler.EventHandler;

public abstract class AbstractEventListener<T> implements EventListener<T> {

    public void onEvent(T event) throws EventException {
        EventHandler<T> eventHandler = getEventHandler(event);
        eventHandler.handle(event);
    }

    protected abstract EventHandler<T> getEventHandler(T event);
}
