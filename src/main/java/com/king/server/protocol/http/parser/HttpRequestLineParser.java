package com.king.server.protocol.http.parser;

import com.king.server.protocol.http.RequestLine;

public interface HttpRequestLineParser {
    /**
     * 解析start line，并返回RequestLine对象
     * Method SP Request-URI SP HTTP-Version CRLF
     */
    RequestLine parse();
}
