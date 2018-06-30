package com.king.server.impl;

import com.king.server.Server;
import com.king.server.ServerStatus;
import com.king.server.config.ServerConfig;
import com.king.server.io.Connector;
import com.king.server.io.IoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class SimpleServer implements Server {
    private static Logger logger = LoggerFactory.getLogger(SimpleServer.class);
    private volatile ServerStatus serverStatus = ServerStatus.STOPED;
    private final int port;
    private final List<Connector> connectorList;

    public SimpleServer(ServerConfig serverConfig, List<Connector> connectorList) {
        this.port = serverConfig.getPort();
        this.connectorList = connectorList;
    }

    @Override
    public void start() throws IOException {
        connectorList.stream().forEach(connector -> connector.start());
        this.serverStatus = ServerStatus.STARTED;
    }

    @Override
    public void stop() {
        connectorList.stream().forEach(connector -> connector.stop());
        this.serverStatus = ServerStatus.STOPED;
        logger.info("Server stop");
    }

    @Override
    public ServerStatus getStatus() {
        return serverStatus;
    }

    @Override
    public int getPort() {
        return port;
    }
}
