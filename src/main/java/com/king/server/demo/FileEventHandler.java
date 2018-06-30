package com.king.server.demo;

import com.king.server.event.handler.AbstractEventHandler;
import com.king.server.event.handler.HandlerException;
import com.king.server.io.connection.Connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileEventHandler extends AbstractEventHandler<Connection> {

    private final String docBase;
    private final FileTransfer fileTransfer = new FileTransfer();

    public FileEventHandler(String docBase) {
        this.docBase = docBase;
    }

    @Override
    protected void doHandle(Connection connection) {

        try {
            getFile(this.docBase, connection.getInputStream(),
                    connection.getOutputStream());
        } catch (IOException e) {
            throw new HandlerException(e);
        }
    }

    /**
     * 返回文件
     *
     * @param inputstream
     * @param outputStream
     */
    private void getFile(String docBase, InputStream inputstream,
                         OutputStream outputStream) {
        fileTransfer.getFile(docBase, inputstream, outputStream);
    }

}
