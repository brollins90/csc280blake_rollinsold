package edu.neumont.csc280.webserver;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;

import javax.xml.ws.Response;

import edu.neumont.servlet.HttpHandler;
import edu.neumont.servlet.HttpRequest;
import edu.neumont.servlet.HttpResponse;

public class ItemHttpHandler implements HttpHandler {

	@Override
	public void doGet(HttpRequest request, HttpResponse response) {
		HttpResponseImpl resp = (HttpResponseImpl)response;
		
		resp.setContentType("text/html");
		resp.setStatusCode(HttpStatusCode.OK.getValue());
		resp.setContent("".getBytes());
		resp.appendContent(("<html>" + "  <body>" + "    <h1>Auction Item #1234</h1>" + "    <img width=\"200\" src=\"http://localhost:8080/lab2/image\"/>" + "    <dl>" + "      <dt>Current Bid:</dt>" + "      <dd>$1.00</dd>" + "      <dt>Time Left</dt>" + "      <dd>2 Days</dd>" + "      <dt>" + "        <input/>" + "      </dt>" + "      <dd>" + "        <input type=\"submit\" value=\"Place a bid\"/>" + "      </dd>" + "    </dl>" + "  </body>" + "</html>").getBytes());
	}

}

//	
//	@Override
//	public void doGet(HttpRequest request, HttpResponse response) {
//		System.out.println("doing get");
//
//		// Set it to failure by default
//		response.setContentType("text/text");
//		response.setStatusCode(HttpStatusCode.ERROR500.getValue());
//
//		// if (response.getStatusCode() == HttpStatusCode.OK.getValue()) {
//
//		System.out.println("uri: " + request.getUri());
//		if (request.getUri().equals("/lab2/item")) {
//			processItemUrl(request, response);
//		} else if (request.getUri().equals("/lab2/image")) {
//			processImageUrl(request, response);
//		} else {
//			processFileNotFound(request, response);
//		}
//		// }
//
//		// try {
//		// System.out.println("flushing");
//		// response.flush();
//		// //System.out.println("closing");
//		// //response.getOutputStream().close();
//		// } catch (IOException e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// }
//
//	}
//
//	public static void processItemUrl(HttpRequest request, HttpResponse response) {
//
//		String responseHtml = "<html>" + "  <body>" + "    <h1>Auction Item #1234</h1>" + "    <img width=\"200\" src=\"http://localhost:8080/lab2/image\"/>" + "    <dl>" + "      <dt>Current Bid:</dt>" + "      <dd>$1.00</dd>" + "      <dt>Time Left</dt>" + "      <dd>2 Days</dd>" + "      <dt>" + "        <input/>" + "      </dt>" + "      <dd>" + "        <input type=\"submit\" value=\"Place a bid\"/>" + "      </dd>" + "    </dl>" + "  </body>" + "</html>";
//		((HttpResponseImpl)response).setContent(responseHtml);
//		// try {
//		// response.getOutputStream().write(responseHtml.getBytes());
//		// response.flush();
//		// } catch (IOException e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// }
//
//	}
//
//	public static void processImageUrl(HttpRequest request, HttpResponse response) {
//		File image = new File("filepath");
//		byte[] imageBytes = new byte[(int) image.length()];
//		FileInputStream fis;
//		try {
//			fis = new FileInputStream(image);
//			BufferedInputStream bis = new BufferedInputStream(fis);
//			bis.read(imageBytes, 0, imageBytes.length);
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void processFileNotFound(HttpRequest request, HttpResponse response) {
//
//		response.setStatusCode(HttpStatusCode.NotFound404.getValue());
//		// response.flush();
//	}
//
//}
