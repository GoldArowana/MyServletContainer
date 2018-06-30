package com.king.server.config;

public class ServerConfig {
    public static final int DEFAUL_PORT = 18080;
    public final int port;

    public ServerConfig() {
        this.port = DEFAUL_PORT;
    }

    public ServerConfig(int port) {
        this.port = port;
    }

    public int getPort() {
        return this.port;
    }
}
