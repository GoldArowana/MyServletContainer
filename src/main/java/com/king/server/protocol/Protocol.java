package com.king.server.protocol;

/**
 * 应用协议接口
 */
public interface Protocol {
    /**
     * 返回协议名
     */
    String getName();

    /**
     * 返回协议版本
     */
    String version();
}
