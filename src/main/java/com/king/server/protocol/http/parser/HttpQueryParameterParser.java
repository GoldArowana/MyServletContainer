package com.king.server.protocol.http.parser;


import com.king.server.protocol.http.HttpQueryParameters;

public interface HttpQueryParameterParser {
    /**
     * 解析QueryString，返回HttpQueryParameter集合
     */
    HttpQueryParameters parse();
}
