package com.king.server.protocol.http;


import com.king.server.protocol.Protocol;

public class HttpProtocol implements Protocol {
    public static final HttpProtocol VERSION11 = new HttpProtocol("1.1");
    public static final HttpProtocol VERSION20 = new HttpProtocol("2.0");
    private final String name = "http";
    private final String version;

    private HttpProtocol(String version) {
        this.version = version;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String version() {
        return this.version;
    }

    @Override
    public String toString() {
        return this.name + "/" + this.version;
    }
}
