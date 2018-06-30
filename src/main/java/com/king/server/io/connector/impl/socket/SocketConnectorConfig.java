package com.king.server.io.connector.impl.socket;

public class SocketConnectorConfig {
    private final int port;
    private final String host;
    private final int backLog;

    public SocketConnectorConfig(int port, String host, int backLog) {
        this.port = port;
        this.host = host;
        this.backLog = backLog;
    }

    public SocketConnectorConfig(int port, String host) {
        this(port, host, 64);
    }

    public SocketConnectorConfig(int port) {
        this(port, null);
    }

    public int getBackLog() {
        return backLog;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }
}
