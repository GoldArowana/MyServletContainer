package com.king.server.protocol.http.handler;


import com.king.server.event.handler.HandlerException;
import com.king.server.io.connection.Connection;
import com.king.server.protocol.http.*;
import com.king.server.protocol.http.body.HttpBody;
import com.king.server.protocol.http.header.HttpHeader;
import com.king.server.protocol.http.header.HttpMessageHeaders;
import com.king.server.protocol.http.parser.AbstractHttpRequestMessageParser;
import com.king.server.protocol.http.response.HttpResponseConstants;
import com.king.server.protocol.http.response.HttpResponseMessageWriter;
import com.king.server.protocol.http.response.ResponseLineConstants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class HttpStaticResourceEventHandler extends AbstractHttpEventHandler {

    private final String docBase;
    private final AbstractHttpRequestMessageParser httpRequestMessageParser;

    public HttpStaticResourceEventHandler(
            String docBase, AbstractHttpRequestMessageParser httpRequestMessageParser) {

        this.docBase = docBase;
        this.httpRequestMessageParser = httpRequestMessageParser;

    }

    @Override
    protected HttpRequestMessage doParserRequestMessage(Connection connection) {
        try {

            HttpRequestMessage httpRequestMessage =
                    httpRequestMessageParser.parse(connection.getInputStream());

            return httpRequestMessage;
        } catch (IOException e) {
            throw new HandlerException(e);
        }
    }

    @Override
    protected HttpResponseMessage doGenerateResponseMessage(
            HttpRequestMessage httpRequestMessage) {

        String path = httpRequestMessage.getRequestLine().getRequestURI().getPath();
        Path filePath = Paths.get(docBase, path);
        //目录、无法读取的文件都返回404
        if (Files.isDirectory(filePath) || !Files.isReadable(filePath)) {
            return HttpResponseConstants.HTTP_404;
        } else {
            ResponseLine ok = ResponseLineConstants.RES_200;

            HttpMessageHeaders headers = HttpMessageHeaders.newBuilder()
                    .addHeader("status", "200").build();

            HttpBody httpBody = null;
            try {
                setContentType(filePath, headers);
                File file = filePath.toFile();

                httpBody = new HttpBody(new FileInputStream(file),
                        HttpConstants.ENCODING_IDENTITY);

                httpBody.setContentLength(file.length());
            } catch (FileNotFoundException e) {
                return HttpResponseConstants.HTTP_404;
            }

            HttpResponseMessage httpResponseMessage =
                    new HttpResponseMessage(ok, headers, Optional.ofNullable(httpBody));

            return httpResponseMessage;
        }

    }

    /**
     * 根据文件后缀设置文件Content-Type
     */
    private void setContentType(Path filePath, HttpMessageHeaders headers) {
        String fileName = filePath.toFile().getName();
        if (fileName.contains(".")) {
            int idx = fileName.lastIndexOf(".");
            fileName = fileName.substring(idx);
        }
        String contentType = ContentTypeUtil.getCotentType(fileName);
        headers.addHeader(new HttpHeader("Content-Type", contentType));
    }

    @Override
    protected void doTransferToClient(HttpResponseMessage responseMessage,
                                      Connection connection) throws IOException {

        HttpResponseMessageWriter httpResponseMessageWriter =
                new HttpResponseMessageWriter();

        httpResponseMessageWriter.write(responseMessage, connection);
    }

}
