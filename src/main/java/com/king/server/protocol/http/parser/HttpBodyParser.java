package com.king.server.protocol.http.parser;


import com.king.server.protocol.http.body.HttpBody;

public interface HttpBodyParser {
    /**
     * 解析并构建HttpBody对象
     */
    HttpBody parse();

}
