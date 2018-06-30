package com.king.server.io.connector;

public class ConnectorException extends RuntimeException {
    public ConnectorException() {
    }

    public ConnectorException(String message) {
        super(message);
    }

    public ConnectorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectorException(Throwable cause) {
        super(cause);
    }

    public ConnectorException(String message,
                              Throwable cause,
                              boolean enableSuppression,
                              boolean writableStackTrace) {

        super(message, cause, enableSuppression, writableStackTrace);

    }
}
