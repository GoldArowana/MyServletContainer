package com.king.server.protocol.http.response;

import com.king.server.io.connection.Connection;
import com.king.server.protocol.http.HttpResponseMessage;
import com.king.server.protocol.http.ResponseLine;
import com.king.server.protocol.http.body.HttpBody;
import com.king.server.protocol.http.header.IMessageHeaders;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

public class HttpResponseMessageWriter {
    public void write(HttpResponseMessage httpResponseMessage, Connection connection)
            throws IOException {
        OutputStream outputStream = connection.getOutputStream();
        ResponseLine responseLine = httpResponseMessage.getResponseLine();
        String responseLineString = responseLine.asString();
        write(outputStream, responseLineString);

        IMessageHeaders headers = httpResponseMessage.getMessageHeaders();
        String headersString = headers.asString();
        write(outputStream, headersString);

        Optional<HttpBody> opHttpBody = httpResponseMessage.getHttpBody();
        if (opHttpBody.isPresent()) {

            IOUtils.copy(opHttpBody.get().getInputStream(), outputStream);
        }
        outputStream.flush();
    }

    private void write(OutputStream outputStream, String message) throws IOException {
        outputStream.write(message.getBytes("utf-8"));
        outputStream.write("\r\n".getBytes());
    }
}
