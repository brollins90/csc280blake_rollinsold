package edu.neumont.csc280.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BlakeHttpServer implements Runnable {

	private static int SERVER_PORT = 8080;
	private boolean running;

	public BlakeHttpServer() {
		running = false;
	}

	@Override
	public void run() {
		System.out.println("Server starting...");

		running = true;
		try (ServerSocket ss = new ServerSocket(BlakeHttpServer.SERVER_PORT)) {
			System.out.println("Server started");

			while (running) {

				Socket clientSocket = null;
				try {
					clientSocket = ss.accept();
				} catch (IOException e) {
					System.out.println("Error connecting to a new client");
				}
				new Thread(new BlakeHttpServerRunnable(clientSocket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
			stopServer();
		}
	}

	private void stopServer() {
		running = false;
	}
}
