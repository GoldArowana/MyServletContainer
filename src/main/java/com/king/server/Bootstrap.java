package com.king.server;

import com.king.server.config.ServerConfig;

import java.io.IOException;

public class Bootstrap {
    public static void main(String[] args) throws IOException {
        ServerConfig serverConfig = new ServerConfig();
        Server server = ServerFactory.getServer(serverConfig);
        server.start();
    }
}
