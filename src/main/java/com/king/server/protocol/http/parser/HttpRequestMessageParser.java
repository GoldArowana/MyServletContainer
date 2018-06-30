package com.king.server.protocol.http.parser;

import com.king.server.protocol.http.HttpMessage;

import java.io.IOException;
import java.io.InputStream;

public interface HttpRequestMessageParser {
    /**
     * 解析输入流中的内容，并构建Http Message对象
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    HttpMessage parse(InputStream inputStream) throws IOException;
}
