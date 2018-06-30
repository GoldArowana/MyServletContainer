package com.king.server.protocol.http.response;

import com.king.server.protocol.http.HttpResponseMessage;
import com.king.server.protocol.http.ResponseLine;
import com.king.server.protocol.http.body.HttpBody;
import com.king.server.protocol.http.header.IMessageHeaders;

import java.util.Optional;

public final class HttpResponseMessageBuilder {
	private ResponseLine responseLine;
	private IMessageHeaders messageHeaders;
	private Optional<HttpBody> httpBody = Optional.empty();

	private HttpResponseMessageBuilder() {
	}

	public static HttpResponseMessageBuilder builder() {
		return new HttpResponseMessageBuilder();
	}

	public HttpResponseMessageBuilder withResponseLine(ResponseLine responseLine) {
		this.responseLine = responseLine;
		return this;
	}

	public HttpResponseMessageBuilder withMessageHeaders(IMessageHeaders messageHeaders) {
		this.messageHeaders = messageHeaders;
		return this;
	}

	public HttpResponseMessageBuilder withHttpBody(Optional<HttpBody> httpBody) {
		this.httpBody = httpBody;
		return this;
	}

	public HttpResponseMessage build() {
		return new HttpResponseMessage(responseLine, messageHeaders, httpBody);
	}
}
