package com.king.server.protocol.http.parser;


import com.king.server.protocol.http.header.HttpMessageHeaders;

public interface HttpHeaderParser {
    /**
     * 解析并返回HttpMessageHeader集合
     *
     * @return
     */
    HttpMessageHeaders parse();
}
