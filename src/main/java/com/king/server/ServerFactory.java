package com.king.server;

import com.king.server.config.ServerConfig;
import com.king.server.impl.SimpleServer;

public class ServerFactory {
    public static Server getServer(ServerConfig serverConfig){
        return new SimpleServer(serverConfig);
    }
}
