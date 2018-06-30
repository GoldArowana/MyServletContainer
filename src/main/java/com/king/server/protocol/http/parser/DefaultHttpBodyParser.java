package com.king.server.protocol.http.parser;

import com.king.server.protocol.http.body.HttpBody;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;

public class DefaultHttpBodyParser implements HttpBodyParser {
    @Override
    public HttpBody parse() {
        long contentLength = HttpParserContext.getBodyInfo().getContentLength();
        InputStream inputStream = HttpParserContext.getInputStream();
        String contentType = HttpParserContext.getContentType();
        String encoding = HttpParserContext.getEncoding();
        String charset = getCharset(contentType);
        String transferEncoding = HttpParserContext.getTransferEncoding();
        HttpBody httpBody =
                new HttpBody(inputStream, transferEncoding);
        httpBody.setCharSet(charset);
        httpBody.setEncoding(encoding);
        httpBody.setContentLength(contentLength);
        return httpBody;
    }

    /**
     * 获取encoding
     * 例如：Content-type: application/json; charset=utf-8
     *
     * @param contentType
     * @return
     */
    private String getCharset(String contentType) {
        String charset = "utf-8";
        if (StringUtils.isNotBlank(contentType) && contentType.contains(";")) {
            charset = contentType.split(";")[1].trim().replace("charset=", "");
        }
        return charset;
    }
}
