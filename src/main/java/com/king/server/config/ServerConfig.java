package com.king.server.config;

public class ServerConfig {
    public static final int DEFAULT_PORT = 18080;
    public final int port;

    public ServerConfig() {
        this.port = DEFAULT_PORT;
    }

    public ServerConfig(int port) {
        this.port = port;
    }

    public int getPort() {
        return this.port;
    }
}
