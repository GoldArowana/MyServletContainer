package com.king.server;

import com.king.server.config.ServerConfig;
import com.king.server.event.impl.SocketEventListener;
import com.king.server.impl.SimpleServer;
import com.king.server.io.Connector;
import com.king.server.io.ConnectorFactory;
import com.king.server.io.socket.SocketConnectorConfig;
import com.king.server.io.socket.SocketConnectorFactory;

import java.util.ArrayList;
import java.util.List;

public class ServerFactory {

    public static Server getServer(ServerConfig serverConfig) {
        List<Connector> connectorList = new ArrayList<>();
        SocketEventListener socketEventListener = new SocketEventListener();
        ConnectorFactory connectorFactory =
                new SocketConnectorFactory(new SocketConnectorConfig(serverConfig.getPort()), socketEventListener);
        connectorList.add(connectorFactory.getConnector());
        return new SimpleServer(serverConfig, connectorList);
    }
}
