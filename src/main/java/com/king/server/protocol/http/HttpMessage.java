package com.king.server.protocol.http;

import com.king.server.protocol.http.body.HttpBody;
import com.king.server.protocol.http.header.IMessageHeaders;

import java.util.Optional;

/**
 * HTTP消息
 * 参考 https://tools.ietf.org/html/rfc2616#page-31
 * <p>
 * generic-message = start-line
 * *(message-header CRLF)
 * CRLF
 * [ message-body ]
 * <p>
 * <p>
 * start-line      = Request-Line | Status-Line
 */
public interface HttpMessage {
    /**
     * 获取起始行
     *
     * @return
     */
    StartLine getStartLine();

    /**
     * 获取HTTP头集合
     *
     * @return
     */
    IMessageHeaders getMessageHeaders();

    /**
     * 获取HTTP Body
     *
     * @return
     */
    Optional<HttpBody> getHttpBody();
}
