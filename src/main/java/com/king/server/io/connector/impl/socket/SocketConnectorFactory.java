package com.king.server.io.connector.impl.socket;

import com.king.server.event.listener.EventListener;
import com.king.server.io.connection.Connection;

public class SocketConnectorFactory {

    public static SocketConnector build(SocketConnectorConfig socketConnectorConfig,
                                        EventListener<Connection> eventListener) {

        return new SocketConnector(
                socketConnectorConfig.getPort(),
                socketConnectorConfig.getHost(),
                socketConnectorConfig.getBackLog(),
                eventListener);

    }

    public static SocketConnector build(int port,
                                        EventListener<Connection> eventListener) {

        return new SocketConnector(port, eventListener);

    }

}
