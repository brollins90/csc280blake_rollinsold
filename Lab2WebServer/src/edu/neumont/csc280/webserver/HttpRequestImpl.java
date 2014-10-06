package edu.neumont.csc280.webserver;

import edu.neumont.servlet.HttpRequest;

public class HttpRequestImpl implements HttpRequest {

	private String uri;

	public HttpRequestImpl(String uri) {
		// System.out.println("created request");
		this.uri = uri;
	}

	@Override
	public String getUri() {
		return this.uri;
	}

}
