package edu.neumont.csc280.webserver;

import edu.neumont.servlet.HttpHandler;
import edu.neumont.servlet.HttpRequest;
import edu.neumont.servlet.HttpResponse;

public class ItemHttpHandler implements HttpHandler {

	@Override
	public void doGet(HttpRequest request, HttpResponse response) {
		HttpResponseImpl resp = (HttpResponseImpl) response;

		resp.setContentType("text/html");
		resp.setStatusCode(HttpStatusCode.OK.getValue());
		resp.setContent("".getBytes());
		resp.appendContent(("<html>" + "  <body>" + "    <h1>Auction Item #1234</h1>" + "    <img width=\"200\" src=\"http://localhost:8080/lab2/image\"/>" + "    <dl>" + "      <dt>Current Bid:</dt>" + "      <dd>$1.00</dd>" + "      <dt>Time Left</dt>" + "      <dd>2 Days</dd>" + "      <dt>" + "        <input/>" + "      </dt>" + "      <dd>" + "        <input type=\"submit\" value=\"Place a bid\"/>" + "      </dd>" + "    </dl>" + "  </body>" + "</html>").getBytes());
	}
}