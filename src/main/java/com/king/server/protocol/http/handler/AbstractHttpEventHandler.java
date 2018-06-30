package com.king.server.protocol.http.handler;

import com.king.server.event.handler.AbstractEventHandler;
import com.king.server.event.handler.HandlerException;
import com.king.server.io.connection.Connection;
import com.king.server.io.connection.socket.SocketConnection;
import com.king.server.protocol.http.HttpRequestMessage;
import com.king.server.protocol.http.HttpResponseMessage;
import org.apache.commons.io.IOUtils;
import java.io.IOException;

public abstract class AbstractHttpEventHandler extends AbstractEventHandler<Connection> {
    @Override
    protected void doHandle(Connection connection) {
        //从输入中构造出HTTP请求对象,Body的内容是延迟读取
        HttpRequestMessage requestMessage = doParserRequestMessage(connection);
        //构造HTTP响应对象
        HttpResponseMessage responseMessage = doGenerateResponseMessage(requestMessage);
        try {
            //输出响应到客户端
            doTransferToClient(responseMessage, connection);
        } catch (IOException e) {
            throw new HandlerException(e);
        } finally {
            //完成响应后，关闭Socket
            if (connection instanceof SocketConnection) {
                IOUtils.closeQuietly(((SocketConnection) connection).getSocket());
            }
        }

    }

    /**
     * 通过输入构造HttpRequestMessage
     *
     * @param connection
     * @return
     */
    protected abstract HttpRequestMessage doParserRequestMessage(Connection connection);

    /**
     * 根据HttpRequestMessage生成HttpResponseMessage
     *
     * @param httpRequestMessage
     * @return
     */
    protected abstract HttpResponseMessage doGenerateResponseMessage(
            HttpRequestMessage httpRequestMessage);

    /**
     * 写入HttpResponseMessage到客户端
     *
     * @param responseMessage
     * @param connection
     * @throws IOException
     */
    protected abstract void doTransferToClient(HttpResponseMessage responseMessage,
                                               Connection connection) throws IOException;
}
