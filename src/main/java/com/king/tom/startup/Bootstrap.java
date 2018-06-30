package com.king.tom.startup;


import com.king.tom.container.ServletContainer;
import com.king.tom.server.Connector;

public class Bootstrap {

    public static void main(String[] args) {
        Connector connector = new Connector();
        ServletContainer container = new ServletContainer();

        connector.setContainer(container).initialise().start();
    }
}
