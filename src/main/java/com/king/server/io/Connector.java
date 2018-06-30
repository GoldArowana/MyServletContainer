package com.king.server.io;

import com.king.server.LifeCycle;

public abstract class Connector implements LifeCycle {
    @Override
    public void start() {
        init();
        acceptConnect();
    }

    protected abstract void init() throws ConnectorException;

    protected abstract void acceptConnect() throws ConnectorException;
}
