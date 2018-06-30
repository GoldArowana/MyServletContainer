package com.king.server;

import com.king.server.config.ServerConfig;
import com.king.server.impl.SimpleServer;

public class ServerFactory {
    /**
     * 返回Server实例
     *
     * @return
     */
    public static Server getServer(ServerConfig serverConfig) {
        return new SimpleServer(serverConfig.getConnectors());
    }
}
