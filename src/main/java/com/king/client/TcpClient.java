package com.king.client;

import java.io.IOException;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",18080);
    }
}
