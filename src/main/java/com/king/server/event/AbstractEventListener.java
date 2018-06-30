package com.king.server.event;

import com.king.server.handler.EventHandler;

public abstract class AbstractEventListener<T> implements EventListener<T> {

    @Override
    public void onEvent(T event) throws EventException {
        EventHandler<T> eventHandler = getEventHandler(event);
        eventHandler.handle(event);
    }

    protected abstract EventHandler<T> getEventHandler(T event);
}
