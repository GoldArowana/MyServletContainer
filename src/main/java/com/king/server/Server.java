package com.king.server;

import java.io.IOException;

public interface Server {
    void start() throws IOException;

    void stop();

    ServerStatus getStatus();

    int getPort();
}
