package com.king.servlet;

import javax.servlet.Servlet;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class ServletContainer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(18080, 10, InetAddress.getByName("localhost"));
        Socket socket = serverSocket.accept();
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        Request request = new Request(input);
        Response response = new Response(output);

//        String uri = request.getRequestURI();
//        String servletName = uri.substring(uri.lastIndexOf("/") + 1);

        URL[] urls = new URL[1];
        File classPath = new File(System.getProperty("user.dir"));
        String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();

        urls[0] = new URL(null, repository, (URLStreamHandler) null);
        URLClassLoader loader = new URLClassLoader(urls);

        Servlet servlet = (Servlet) loader.loadClass(/*servletName*/"PrimitiveServlet").newInstance();
        servlet.service(request, response);

    }
}
