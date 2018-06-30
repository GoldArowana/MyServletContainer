package com.king.server.protocol.http;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Content Type工具类
 */
public class ContentTypeUtil {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ContentTypeUtil.class);

    private static Properties properties;

    static {
        properties = new Properties();
        try {

            properties.load(ContentTypeUtil.class
                    .getClassLoader()
                    .getResourceAsStream("mime-mapping.properties"));

        } catch (IOException e) {
            LOGGER.error("load mime-mapping.properties failed", e);
        }
    }

    private ContentTypeUtil() {
    }

    /**
     * 通过文件后缀获取到Content-Type
     */
    public static String getCotentType(String filePrefix) {
        return properties.getProperty(filePrefix, "application/octet-stream");
    }

}
