package com.king.server.impl;

import com.king.server.LifeCycle;
import com.king.server.Server;
import com.king.server.ServerStatus;
import com.king.server.io.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class SimpleServer implements Server {
    private static final Logger logger = LoggerFactory.getLogger(SimpleServer.class);
    private final Set<Connector> connectors;
    private volatile ServerStatus serverStatus = ServerStatus.STOPED;

    public SimpleServer(Set<Connector> connectorList) {
        this.connectors = connectorList;
    }

    @Override
    public void start() {
        connectors.forEach(LifeCycle::start);
        this.serverStatus = ServerStatus.STARTED;
    }

    @Override
    public void stop() {
        connectors.forEach(LifeCycle::stop);
        this.serverStatus = ServerStatus.STOPED;
        logger.info("Server stop");
    }

    @Override
    public ServerStatus getStatus() {
        return serverStatus;
    }

    @Override
    public Set<Connector> getConnectors() {
        return connectors;
    }
}
