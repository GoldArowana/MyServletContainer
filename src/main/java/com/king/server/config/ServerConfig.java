package com.king.server.config;

import com.king.server.io.connector.Connector;

import java.util.HashSet;
import java.util.Set;

public class ServerConfig {
    private final Set<Connector> connectors;

    private ServerConfig(Builder builder) {
        connectors = builder.connectors;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Set<Connector> getConnectors() {
        return connectors;
    }

    public static final class Builder {
        private Set<Connector> connectors;

        private Builder() {
            connectors = new HashSet<>(16);
        }

        public Builder addConnector(Connector connector) {
            this.connectors.add(connector);
            return this;
        }

        public ServerConfig build() {
            return new ServerConfig(this);
        }
    }
}
