package com.king.server;

import com.king.server.config.ServerConfig;
import com.king.server.io.IoUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import static org.junit.Assert.assertTrue;

public class TestServerAcceptRequest extends TestServerBase {
    // 设置超时时间为500毫秒
    private static final int TIMEOUT = 500;
    private static Logger logger = LoggerFactory.getLogger(TestServerAcceptRequest.class);
    private static Server server;

    @BeforeClass
    public static void init() {
        ServerConfig serverConfig = new ServerConfig();
        server = ServerFactory.getServer(serverConfig);
    }

    @AfterClass
    public static void destroy() {
        server.stop();
    }

    @Test
    public void testServerAcceptRequest() {
        // 如果server没有启动，首先启动server
        if (server.getStatus().equals(ServerStatus.STOPED)) {
            startServer(server);
            waitServerStart(server);
            Socket socket = new Socket();
            SocketAddress endpoint = new InetSocketAddress("localhost",
                    ServerConfig.DEFAULT_PORT);
            try {
                // 试图发送请求到服务器，超时时间为TIMEOUT
                socket.connect(endpoint, TIMEOUT);
                assertTrue("服务器启动后，能接受请求", socket.isConnected());
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            } finally {
                IoUtils.closeQuietly(socket);
            }
        }
    }
}
