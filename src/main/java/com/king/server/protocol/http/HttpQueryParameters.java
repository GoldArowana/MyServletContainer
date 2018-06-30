package com.king.server.protocol.http;

import com.google.common.collect.LinkedListMultimap;

import java.util.List;
import java.util.Set;

public class HttpQueryParameters {

    private final LinkedListMultimap<String, HttpQueryParameter> prametersMultiMap;

    public HttpQueryParameters() {
        this.prametersMultiMap = LinkedListMultimap.create();
    }


    public List<HttpQueryParameter> getQueryParameter(String name) {
        return this.prametersMultiMap.get(name);
    }

    public HttpQueryParameter getFirstQueryParameter(String name) {
        if (this.prametersMultiMap.containsKey(name)) {
            return this.prametersMultiMap.get(name).get(0);
        }
        return null;
    }

    public List<HttpQueryParameter> getAllQueryParameters() {
        return this.prametersMultiMap.values();
    }

    public void addQueryParameter(HttpQueryParameter httpQueryParameter) {
        this.prametersMultiMap.put(httpQueryParameter.getName(), httpQueryParameter);
    }

    public void removeQueryParameter(HttpQueryParameter httpQueryParameter) {
        this.prametersMultiMap.remove(httpQueryParameter.getName(), httpQueryParameter);
    }

    public void removeQueryParameter(String httpQueryParameter) {
        this.prametersMultiMap.removeAll(httpQueryParameter);
    }

    public boolean hasRequestParameter(String httpQueryParameter) {
        return this.prametersMultiMap.containsKey(httpQueryParameter);
    }

    public Set<String> getQueryParameterNames() {
        return this.prametersMultiMap.keySet();
    }
}
