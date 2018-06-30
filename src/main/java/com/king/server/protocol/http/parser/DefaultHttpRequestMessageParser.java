package com.king.server.protocol.http.parser;


import com.king.server.protocol.http.HttpQueryParameters;
import com.king.server.protocol.http.RequestLine;
import com.king.server.protocol.http.body.HttpBody;
import com.king.server.protocol.http.header.HttpMessageHeaders;
import com.king.server.protocol.http.header.IMessageHeaders;

import java.util.Optional;

import static com.king.server.protocol.http.HttpConstants.CONTENT_TYPE;


public class DefaultHttpRequestMessageParser extends AbstractHttpRequestMessageParser {
    private final HttpRequestLineParser httpRequestLineParser;
    private final HttpQueryParameterParser httpQueryParameterParser;
    private final HttpHeaderParser httpHeaderParser;
    private final HttpBodyParser httpBodyParser;

    public DefaultHttpRequestMessageParser(HttpRequestLineParser httpRequestLineParser,
                                           HttpQueryParameterParser httpQueryParameterParser,
                                           HttpHeaderParser httpHeaderParser,
                                           HttpBodyParser httpBodyParser) {
        this.httpRequestLineParser = httpRequestLineParser;
        this.httpQueryParameterParser = httpQueryParameterParser;
        this.httpHeaderParser = httpHeaderParser;
        this.httpBodyParser = httpBodyParser;
    }

    @Override
    protected RequestLine parseRequestLine() {
        RequestLine requestLine = this.httpRequestLineParser.parse();
        HttpParserContext.setHttpMethod(requestLine.getMethod());
        HttpParserContext.setRequestQueryString(requestLine.getRequestURI().getQuery());
        return requestLine;
    }

    @Override
    protected HttpQueryParameters parseHttpQueryParameters() {
        return this.httpQueryParameterParser.parse();
    }

    @Override
    protected IMessageHeaders parseRequestHeaders() {
        HttpMessageHeaders httpMessageHeaders = this.httpHeaderParser.parse();
        if (httpMessageHeaders.hasHeader(CONTENT_TYPE)) {
            HttpParserContext.setContentType(httpMessageHeaders.getFirstHeader(CONTENT_TYPE).getValue());
        }
        return httpMessageHeaders;
    }

    @Override
    protected Optional<HttpBody> parseRequestBody() {
        if (isHasBodyMethod()) {
            HttpBody httpBody = this.httpBodyParser.parse();
            return Optional.ofNullable(httpBody);
        }
        return Optional.empty();
    }

    /**
     * 判断HTTP请求是否有Body，只支持POST和PUT
     * @return
     */
    private boolean isHasBodyMethod() {
        return ("POST".equals(HttpParserContext.getHttpMethod())
                || "PUT".equals(HttpParserContext.getHttpMethod()))
                && HttpParserContext.getHasBody();
    }


}
