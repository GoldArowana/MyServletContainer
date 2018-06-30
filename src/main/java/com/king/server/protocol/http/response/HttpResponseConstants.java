package com.king.server.protocol.http.response;

import com.king.server.protocol.http.HttpResponseMessage;
import com.king.server.protocol.http.header.HttpMessageHeaders;

public interface HttpResponseConstants {
    HttpResponseMessage HTTP_404 = HttpResponseMessageBuilder.builder()
            .withResponseLine(ResponseLineConstants.RES_404)
            .withMessageHeaders(HttpMessageHeaders
                    .newBuilder()
                    .addHeader("Content-Type", "text/html")
                    .build())
            .build();
}
