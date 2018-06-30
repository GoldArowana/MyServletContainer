package com.king.server.impl;

import com.king.server.Server;
import com.king.server.ServerStatus;
import com.king.server.config.ServerConfig;
import com.king.server.io.IoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer implements Server {
    private static Logger logger = LoggerFactory.getLogger(SimpleServer.class);
    private volatile ServerStatus serverStatus = ServerStatus.STOPED;
    private final int port;
    private ServerSocket serverSocket;

    public SimpleServer(ServerConfig serverConfig) {
        this.port = serverConfig.getPort();
    }

    @Override
    public void start() throws IOException {
        {
            this.serverSocket = new ServerSocket(this.port);
            this.serverStatus = ServerStatus.STARTED;
        }

        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                logger.info("新增连接：" + socket.getInetAddress() + ":" + socket.getPort());
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            } finally {
                IoUtils.closeQuietly(socket);
            }
        }
    }

    @Override
    public void stop() {
        IoUtils.closeQuietly(this.serverSocket);
        this.serverStatus = ServerStatus.STOPED;
        logger.info("Server stop");
    }

    @Override
    public ServerStatus getStatus() {
        return serverStatus;
    }

    @Override
    public int getPort() {
        return port;
    }
}
