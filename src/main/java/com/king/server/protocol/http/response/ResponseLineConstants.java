package com.king.server.protocol.http.response;


import com.king.server.protocol.http.HttpProtocol;
import com.king.server.protocol.http.ResponseLine;

public interface ResponseLineConstants {
    ResponseLine RES_404 = new ResponseLine(
            HttpProtocol.VERSION11.toString(),
            HttpStatus.STATUS_404.getStatusCode(),
            HttpStatus.STATUS_404.getReason());

    ResponseLine RES_200 = new ResponseLine(
            HttpProtocol.VERSION11.toString(),
            HttpStatus.STATUS_200.getStatusCode(),
            HttpStatus.STATUS_200.getReason());

}
