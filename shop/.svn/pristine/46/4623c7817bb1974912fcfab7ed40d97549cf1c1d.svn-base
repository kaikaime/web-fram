package com.serversocket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class ClientSocket implements Runnable{
	private Socket socket;
	public ClientSocket(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		Thread readThread = new Thread(new ClientReadThread(socket));
		Thread writeThread = new Thread(new ClientWirterThread(socket));
		readThread.start();
		writeThread.start();
	}

}
