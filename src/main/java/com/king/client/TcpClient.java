package com.king.client;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 18080);
//        BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        while (true) {
//            System.out.println(bf.readLine());
//        }
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("kkkll\n");
        writer.flush();

    }
}
