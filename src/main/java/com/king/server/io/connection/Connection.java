package com.king.server.io.connection;

import java.io.IOException;

public interface Connection {
    void write(byte[] bytes) throws IOException;

    void write(byte[] bytes, int offset, int length) throws IOException;

    int read(byte[] bytes) throws IOException;

    int read(byte[] bytes, int offset, int length) throws IOException;
}
