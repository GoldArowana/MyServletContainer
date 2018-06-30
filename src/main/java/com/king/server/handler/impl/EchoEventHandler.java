package com.king.server.handler.impl;

import com.king.server.handler.AbstractEventHandler;
import com.king.server.handler.HandlerException;
import com.king.server.io.IoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class EchoEventHandler extends AbstractEventHandler<Socket> {
    private static Logger logger = LoggerFactory.getLogger(EchoEventHandler.class);

    @Override
    protected void doHandle(Socket socket) {
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
                logger.info("从客户端读到了:" + line);
                if (line.equals("stop")) {
                    printWriter.append("bye bye.\n");
                    printWriter.flush();
                    break;
                } else {
                    printWriter.append(line);
                    printWriter.append("\n");
                    printWriter.flush();
                }
            }
        } catch (IOException e) {
            throw new HandlerException(e);
        } finally {
            IoUtils.closeQuietly(inputstream);
            IoUtils.closeQuietly(outputStream);
        }
    }

}
