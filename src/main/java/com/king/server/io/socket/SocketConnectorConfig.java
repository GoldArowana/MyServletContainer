package com.king.server.io.socket;

public class SocketConnectorConfig {
    private final int port;

    public SocketConnectorConfig(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
}
