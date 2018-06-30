package com.king.server.io.connector;

import com.king.server.LifeCycle;

public interface Connector extends LifeCycle {
    /**
     * 获取监听的端口
     */
    int getPort();

    /**
     * 获取监听的IP、主机名
     */
    String getHost();
}
