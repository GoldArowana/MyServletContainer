package com.king.server;

import com.king.server.io.connector.Connector;

import java.io.IOException;
import java.util.Set;

public interface Server {
    void start() throws IOException;

    void stop();

    ServerStatus getStatus();

    Set<Connector> getConnectors();
}
