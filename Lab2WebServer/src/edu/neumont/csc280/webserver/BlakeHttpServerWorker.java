package edu.neumont.csc280.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.InvalidParameterException;

import edu.neumont.servlet.HttpResponse;

public class BlakeHttpServerWorker implements Runnable {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private HttpResponse response;

	private static ItemHttpHandler itemHandler = new ItemHttpHandler();
	private static ImageHttpHandler imageHandler = new ImageHttpHandler();

	public BlakeHttpServerWorker(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			// Open the streams
			System.out.println("Opened streams");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);

			System.out.println("created response");
			response = new HttpResponseImpl(socket.getOutputStream());

			String firstLine = in.readLine();

			// System.out.println("firstline: " + firstLine);
			String[] requestParts = firstLine.split(" ");
			if (requestParts.length != 3) {
				// response.setStatusCode(HttpStatusCode.ERROR500.getValue());
				throw new InvalidParameterException("HttpRequest does not contain 3 parts.");
			}

			// 0 should be "GET"
			if (!requestParts[0].equalsIgnoreCase("GET")) {
				// response.setStatusCode(HttpStatusCode.ERROR500.getValue());
				throw new InvalidParameterException(requestParts[0] + " is an unsupported method.");
			}
			// 2 should be "HTTP/1.1"
			if (!requestParts[2].equalsIgnoreCase("HTTP/1.1")) {
				// response.setStatusCode(HttpStatusCode.ERROR500.getValue());
				throw new InvalidParameterException(requestParts[0] + " is an unsupported protocol version.");
			}

			HttpRequestImpl request = new HttpRequestImpl(requestParts[1]);
			System.out.println(requestParts[1]);
			// HttpRequestImpl request = new HttpRequestImpl("/lab2/item");
			// System.out.println("doget");
			// itemHandler.doGet(request, response);

			// 1 should be the path
			if (request.getUri().equals("/lab2/item")) {
				itemHandler.doGet(request, response);
			} else if (request.getUri().equals("/lab2/image")) {
				imageHandler.doGet(request, response);
			} else {
				response.setStatusCode(HttpStatusCode.NotFound404.getValue());
				// throw new InvalidParameterException(requestParts[0] + " not a valid path.");
			}
			response.flush();

		} catch (Exception e) {
			response.setStatusCode(HttpStatusCode.ERROR500.getValue());
			try {
				response.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
