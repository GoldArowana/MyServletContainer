package com.king.server.io.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Connection {
    /**
     * 写入byte[]数组中的所有数据
     */
    void write(byte[] bytes) throws IOException;

    /**
     * 写入byte[]数组中[offset,length-1]的数据
     */
    void write(byte[] bytes, int offset, int length) throws IOException;

    /**
     * 读取数据填满byte[]数组
     */
    int read(byte[] bytes) throws IOException;

    /**
     * 读取数据写入byte[offset,length-1]
     */
    int read(byte[] bytes, int offset, int length) throws IOException;

    /**
     * 获取Socket中的输入流
     */
    InputStream getInputStream() throws IOException;

    /**
     * 获取Socket中的输出流
     */
    OutputStream getOutputStream() throws IOException;
}
