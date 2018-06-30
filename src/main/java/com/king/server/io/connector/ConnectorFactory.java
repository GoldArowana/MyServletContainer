package com.king.server.io.connector;

public interface ConnectorFactory {
    /**
     * 返回Connector
     */
    AbstractConnector getConnector();
}
