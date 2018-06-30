package com.king.server;


import com.king.server.io.connector.Connector;

import java.io.IOException;
import java.util.Set;

/**
 * server接口
 */
public interface Server {
    /**
     * g
     * <p>
     * 启动服务器
     */
    void start() throws IOException;

    /**
     * 关闭服务器
     */
    void stop();

    /**
     * 获取服务器启停状态
     */
    ServerStatus getStatus();

    /**
     * 获取服务器管理的Connector列表
     */
    Set<Connector> getConnectors();
}
