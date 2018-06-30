package com.king.server.io.connector;

import com.king.server.io.connection.Connection;

import java.nio.channels.SelectionKey;

public abstract class AbstractChannelConnector extends AbstractConnector {
    /**
     * 通过SelectableChannel通信
     */
    protected abstract void communicate(SelectionKey selectionKey) throws ConnectorException;

    @Override
    protected void communicate(Connection connection) throws ConnectorException {
        throw new ConnectorException("not support BIO.");
    }
}
