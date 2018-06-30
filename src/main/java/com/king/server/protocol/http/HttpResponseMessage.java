package com.king.server.protocol.http;


import com.king.server.protocol.http.body.HttpBody;
import com.king.server.protocol.http.header.IMessageHeaders;

import java.util.Optional;

public class HttpResponseMessage implements HttpMessage {
    private final ResponseLine responseLine;
    private final IMessageHeaders messageHeaders;
    private final Optional<HttpBody> httpBody;

    public HttpResponseMessage(ResponseLine responseLine,
                               IMessageHeaders messageHeaders,
                               Optional<HttpBody> httpBody) {

        this.responseLine = responseLine;
        this.messageHeaders = messageHeaders;
        this.httpBody = httpBody;
    }

    @Override
    public StartLine getStartLine() {
        return StartLine.class.cast(this.responseLine);
    }

    @Override
    public IMessageHeaders getMessageHeaders() {
        return this.messageHeaders;
    }

    @Override
    public Optional<HttpBody> getHttpBody() {
        return this.httpBody;
    }

    public ResponseLine getResponseLine() {
        return responseLine;
    }

}
