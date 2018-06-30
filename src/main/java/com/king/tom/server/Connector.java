package com.king.tom.server;


import com.king.tom.container.ServletContainer;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Connector implements Runnable {

    private static final int POOL_SIZE = Constants.POOL_SIZE;

    private ServletContainer container;
    private ExecutorService service;
    private Deque<Processor> processors;

    public Connector start() {
        Thread thread = new Thread(this);
        thread.start();

        return this;
    }

    public Connector initialise() {
        service = Executors.newFixedThreadPool(POOL_SIZE);
        processors = new LinkedList<Processor>();

        for (int i = 0; i < POOL_SIZE; i++) {
            Processor processor = new Processor(this);
            processors.addLast(processor);
        }

        return this;
    }

    public void recycle(Processor processor) {
        synchronized (processors) {
            processors.addLast(processor);
        }
    }

    public Processor getProcessor() {
        synchronized (processors) {
            return processors.pollFirst();
        }
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(Constants.PORT, Constants.BACK_LOG,
                InetAddress.getByName(Constants.HOST))) {

            while (true) {
                Socket socket = serverSocket.accept();

                Processor processor = getProcessor();
                if (processor != null) {
                    processor.assign(socket);
                    service.submit(processor);
                } else {
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Request createRequest(InputStream input) {
        return new Request(input);
    }

    public Response createResponse(OutputStream output) {
        return new Response(output);
    }

    public ServletContainer getContainer() {
        return container;
    }

    public Connector setContainer(ServletContainer container) {
        this.container = container;
        return this;
    }

}
