package com.king.server.io.connection;


import java.io.IOException;
import java.nio.ByteBuffer;

@Deprecated
public interface ChannelConnection extends Connection {

    byte[] read(ByteBuffer byteBuffer) throws IOException;
}
