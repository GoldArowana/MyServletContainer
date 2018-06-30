package com.king.server.protocol.http.header;

import java.util.List;
import java.util.Set;

public interface IMessageHeaders {

    /**
     * 获取名字为headerName的HttpHeader列表
     */
    List<HttpHeader> getHeaders(String headerName);

    /**
     * 获取第一个名字为headerName的HttpHeader
     */
    HttpHeader getFirstHeader(String headerName);

    /**
     * 获取所有的HttpHeader
     */
    List<HttpHeader> getAllHeaders();

    /**
     * 添加HttpHeader到集合中
     */
    void addHeader(HttpHeader httpHeader);

    /**
     * 从集合中移除HttpHeader
     */
    void removeHeader(HttpHeader httpHeader);

    /**
     * 从集合中移除名字为headerName的所有HttpHeader
     */
    void removeHeaders(String headerName);

    /**
     * 判断集合中是否包含名字为headerName的HttpHeader
     */
    boolean hasHeader(String headerName);

    /**
     * 返回所有HttpHeader的名字，并去重
     */
    Set<String> getHeaderNames();

    /**
     * 将Headers集合中的键值对转换为HTTP协议中规定的字符串格式：
     * key:value CRLF
     */
    String asString();
}
