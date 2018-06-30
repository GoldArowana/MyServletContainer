package com.king.server.protocol.http.response;


@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
public enum HttpStatus {
    STATUS_404(404, "Not Found"), STATUS_200(200, "OK");
    private int statusCode;
    private String reason;

    HttpStatus(int statusCode, String reason) {
        this.statusCode = statusCode;
        this.reason = reason;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReason() {
        return reason;
    }
}
