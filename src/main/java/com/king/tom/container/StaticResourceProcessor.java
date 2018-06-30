package com.king.tom.container;

import com.king.tom.server.Request;
import com.king.tom.server.Response;

import java.io.IOException;

public class StaticResourceProcessor {

    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
