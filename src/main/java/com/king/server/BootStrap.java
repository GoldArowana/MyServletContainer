package com.king.server;


import com.king.server.config.ServerConfig;
import com.king.server.event.listener.EventListener;
import com.king.server.io.connection.Connection;
import com.king.server.io.connector.impl.socket.SocketConnector;
import com.king.server.io.connector.impl.socket.SocketConnectorFactory;
import com.king.server.io.event.listener.impl.ConnectionEventListener;
import com.king.server.protocol.http.handler.HttpStaticResourceEventHandler;
import com.king.server.protocol.http.parser.*;

import java.io.IOException;

public class BootStrap {
    public static void main(String[] args) throws IOException {
        /*EventListener<Connection> socketEventListener =
                new ConnectionEventListener(new EchoEventHandler());
        SocketConnector connector = SocketConnectorFactory.build(18080, socketEventListener);

        EventListener<Connection> socketEventListener2 =
                new ConnectionEventListener(new FileEventHandler(System.getProperty("user.dir")));
        SocketConnector connector2 =
                SocketConnectorFactory.build(18081, socketEventListener2);*/

        EventListener<Connection> socketEventListener3 =
                new ConnectionEventListener(new HttpStaticResourceEventHandler(System.getProperty("user.dir"),
                        new DefaultHttpRequestMessageParser(new DefaultHttpRequestLineParser(),
                                new DefaultHttpQueryParameterParser(),
                                new DefaultHttpHeaderParser(),
                                new DefaultHttpBodyParser())));
        SocketConnector connector3 =
                SocketConnectorFactory.build(18083, socketEventListener3);

        /*EventListener<SelectionKey> nioEventListener = new SelectableChannleEventListener(new NIOEchoEventHandler());
        SocketChannelConnector socketChannelConnector = new SocketChannelConnector(18082, nioEventListener);*/


        ServerConfig serverConfig = ServerConfig.builder()
              //  .addConnector(connector)
                //.addConnector(connector2)
                .addConnector(connector3)
                //.addConnector(socketChannelConnector)
                .build();
        Server server = ServerFactory.getServer(serverConfig);
        server.start();
    }
}
