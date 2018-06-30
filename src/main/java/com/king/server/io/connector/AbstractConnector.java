package com.king.server.io.connector;

import com.king.server.io.connection.Connection;

public abstract class AbstractConnector implements Connector {
    @Override
    public void start() {
        init();
        acceptConnect();
    }

    /**
     * 初始化connector
     * 一般为启动端口监听
     * @throws ConnectorException
     */
    protected abstract void init() throws ConnectorException;

    /**
     * 接收请求连接
     * @throws ConnectorException
     */
    protected abstract void acceptConnect() throws ConnectorException;

    /**
     * 使用connection进行通信
     * @param connection
     * @throws ConnectorException
     */
    protected abstract void communicate(Connection connection) throws ConnectorException;
}
