package com.king.server.protocol.http;

public class HttpQueryParameter {
    private final String name;
    private final String value;

    public HttpQueryParameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "HttpQueryParameter{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
