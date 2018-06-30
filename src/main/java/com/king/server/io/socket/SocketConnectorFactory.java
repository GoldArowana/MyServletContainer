package com.king.server.io.socket;

import com.king.server.io.Connector;
import com.king.server.io.ConnectorFactory;

public class SocketConnectorFactory implements ConnectorFactory {
    private final SocketConnectorConfig socketConnectorConfig;

    public SocketConnectorFactory(SocketConnectorConfig socketConnectorConfig) {
        this.socketConnectorConfig = socketConnectorConfig;
    }

    @Override
    public Connector getConnector() {
        return new SocketConnector(this.socketConnectorConfig.getPort());
    }
}