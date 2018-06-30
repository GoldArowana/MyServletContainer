package com.king.server.io.event.listener.impl;

import com.king.server.event.handler.EventHandler;
import com.king.server.event.listener.AbstractEventListener;
import com.king.server.io.connection.Connection;

public class ConnectionEventListener extends AbstractEventListener<Connection> {

    private final EventHandler<Connection> eventHandler;

    public ConnectionEventListener(EventHandler<Connection> eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    protected EventHandler<Connection> getEventHandler(Connection event) {
        return this.eventHandler;
    }
}
