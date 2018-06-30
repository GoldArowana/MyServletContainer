package com.king.server.io.connector;

import com.king.server.io.connection.Connection;

public abstract class AbstractConnector implements Connector {
    @Override
    public void start() {
        init();
        acceptConnect();
    }

    protected abstract void init() throws ConnectorException;

    protected abstract void acceptConnect() throws ConnectorException;

    protected abstract void communicate(Connection connection) throws ConnectorException;
}
