package com.king.server.protocol.http.parser;

import com.king.server.protocol.http.HttpQueryParameter;
import com.king.server.protocol.http.HttpQueryParameters;

import static com.king.server.protocol.http.HttpConstants.KV_SPLITTER;

public class DefaultHttpQueryParameterParser implements HttpQueryParameterParser {
    private static final String SPLITTER = "&";
    private final HttpQueryParameters httpQueryParameters;

    public DefaultHttpQueryParameterParser() {
        this.httpQueryParameters = new HttpQueryParameters();
    }

    @Override
    public HttpQueryParameters parse() {
        String queryString = HttpParserContext.getRequestQueryString();
        if (queryString != null) {
            String[] keyValues = queryString.split(SPLITTER);
            for (String keyValue : keyValues) {
                if (keyValue.contains(KV_SPLITTER)) {
                    String[] temp = keyValue.split(KV_SPLITTER);
                    if (temp.length == 2) {

                        this.httpQueryParameters.addQueryParameter(
                                new HttpQueryParameter(temp[0], temp[1]));

                    }
                }
            }
        }
        return this.httpQueryParameters;
    }
}
