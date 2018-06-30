package com.king.server.event.impl;

import com.king.server.event.AbstractEventListener;
import com.king.server.handler.EventHandler;

import java.net.Socket;

public class SocketEventListener extends AbstractEventListener<Socket> {

    private final EventHandler<Socket> eventHandler;

    public SocketEventListener(EventHandler<Socket> eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    protected EventHandler<Socket> getEventHandler(Socket event) {
        return eventHandler;
    }
}