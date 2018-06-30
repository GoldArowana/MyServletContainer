package com.king.server;

import com.king.server.config.ServerConfig;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestServer extends TestServerBase {
    private static Server server;

    @BeforeClass
    public static void init() {
        ServerConfig serverConfig = new ServerConfig();
        server = ServerFactory.getServer(serverConfig);
    }

    @Test
    public void testServerStart() {
        startServer(server);
        waitServerStart(server);
        assertTrue("服务器启动后，状态是STARTED", server.getStatus().equals(ServerStatus.STARTED));
    }

    @Test
    public void testServerStop() {
        server.stop();
        assertTrue("服务器关闭后，状态是STOPED", server.getStatus().equals(ServerStatus.STOPED));
    }

    @Test
    public void testServerPort() {
        int port = server.getPort();
        assertTrue("默认端口号", ServerConfig.DEFAULT_PORT == port);
    }

}
