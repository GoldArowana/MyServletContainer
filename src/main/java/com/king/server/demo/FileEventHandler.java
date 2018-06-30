package com.king.server.demo;

import com.king.server.event.handler.AbstractEventHandler;
import com.king.server.io.connection.Connection;

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

       /* fileTransfer.getFile(this.docBase, connection.getInputStream(),
                connection.getOutputStream());*/
    }

    private void getFile(String docBase, InputStream inputstream, OutputStream outputStream) {
        fileTransfer.getFile(docBase, inputstream, outputStream);
    }

}
