package com.king.server.io.connection.socket;

import com.king.server.io.connection.Connection;

import java.io.IOException;
import java.net.Socket;

public class SocketConnection implements Connection {
    private final Socket socket;

    public SocketConnection(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        this.write(bytes, 0, bytes.length);
    }

    @Override
    public void write(byte[] bytes, int offset, int length) throws IOException {

        this.socket.getOutputStream().write(bytes, offset, length);

    }

    @Override
    public int read(byte[] bytes) throws IOException {
        return this.read(bytes, 0, bytes.length);
    }

    @Override
    public int read(byte[] bytes, int offset, int length) throws IOException {
        return this.socket.getInputStream().read(bytes, offset, length);
    }
}
