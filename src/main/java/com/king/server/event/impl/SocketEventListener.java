package com.king.server.event.impl;

import com.king.server.event.EventException;
import com.king.server.event.EventListener;
import com.king.server.io.IoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketEventListener implements EventListener<Socket> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketEventListener.class);

    @Override
    public void onEvent(Socket socket) throws EventException {
        LOGGER.info("新增连接：" + socket.getInetAddress() + ":" + socket.getPort());
        try {
            echo(socket);
        } catch (IOException e) {
            throw new EventException(e);
        }
    }

    private void echo(Socket socket) throws IOException {
        InputStream inputstream = null;
        OutputStream outputStream = null;
        try {
            inputstream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(inputstream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.append("Server connected.Welcome to echo.\n");
            printWriter.flush();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                LOGGER.info("从客户端读到了:" + line);
                if (line.equals("stop")) {
                    printWriter.append("bye bye.\n");
                    printWriter.flush();
                    break;
                } else {
                    printWriter.append(line);
                    printWriter.append("\n");
                    printWriter.flush();
                    LOGGER.info("向客户端发送了:" + line);
                }
            }
        } finally {
            IoUtils.closeQuietly(inputstream);
            IoUtils.closeQuietly(outputStream);
        }
    }
}

