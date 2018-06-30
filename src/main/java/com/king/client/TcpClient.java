package com.king.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class TcpClient {
    private static Logger logger = LoggerFactory.getLogger(TcpClient.class);

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket("localhost", 18080);

        new Thread(() -> {
            OutputStreamWriter writer = null;
            try {
                writer = new OutputStreamWriter(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scanner scan = new Scanner(System.in);
            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                try {
                    if (writer != null) {
                        writer.write(str + "\r\n");
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                logger.info("客户端写入了:" + str);
            }
        }).start();


        BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true) {
            String str = bf.readLine();
            if (str == null) {
                logger.info("break");
                break;
            }
            System.out.println(str);
        }
    }
}
