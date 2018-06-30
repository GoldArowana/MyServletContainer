package com.king.server.io.socket;

import com.king.server.io.Connector;
import com.king.server.io.ConnectorException;
import com.king.server.io.IoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketConnector extends Connector {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketConnector.class);
    private final int port;
    private ServerSocket serverSocket;
    private volatile boolean started = false;

    public SocketConnector(int port) {
        this.port = port;
    }

    @Override
    protected void init() throws ConnectorException {
        //监听本地端口，如果监听不成功，抛出异常
        try {
            this.serverSocket = new ServerSocket(this.port);
            this.started = true;
        } catch (IOException e) {
            throw new ConnectorException(e);
        }
    }

    @Override
    protected void acceptConnect() throws ConnectorException {
        new Thread(() -> {
            while (started) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                    LOGGER.info("新增连接：" + socket.getInetAddress() + ":" + socket.getPort());
                } catch (IOException e) {
                    //单个Socket异常，不要影响整个Connector
                    LOGGER.error(e.getMessage(), e);
                } finally {
                    IoUtils.closeQuietly(socket);
                }
            }
        }).start();
    }

    @Override
    public void stop() {
        this.started = false;
        IoUtils.closeQuietly(this.serverSocket);
    }
}

