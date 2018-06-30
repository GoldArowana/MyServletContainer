package com.king.server.io.socket;

import com.king.server.event.impl.SocketEventListener;
import com.king.server.io.Connector;
import com.king.server.io.ConnectorFactory;

public class SocketConnectorFactory implements ConnectorFactory {
    private final SocketConnectorConfig socketConnectorConfig;
    private final SocketEventListener socketEventListener;


    public SocketConnectorFactory(SocketConnectorConfig socketConnectorConfig, SocketEventListener socketEventListener) {
        this.socketConnectorConfig = socketConnectorConfig;
        this.socketEventListener = socketEventListener;
    }

    @Override
    public Connector getConnector() {
        return new SocketConnector(this.socketConnectorConfig.getPort(), socketEventListener);
    }
}