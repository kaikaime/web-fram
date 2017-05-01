package com.serversocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainServerSocket {
	private int serverPort = 7736;
	private boolean isStartService=false;//服务器开启开关
	private int nThreads = 100;//线程池大小
	private ServerSocket serverSocket = null;
	private ExecutorService newFixedThreadPool = null;
	private Map<String,Socket> socketPool =
			Collections.synchronizedMap(new HashMap<String,Socket>());
	
	public MainServerSocket(int serverPort){
		this.serverPort = serverPort;
		this.isStartService = true;
		this.createServerSocket();
	}
	
	
	@SuppressWarnings("null")
	public void createServerSocket(){
		try {
			serverSocket = new ServerSocket(serverPort);
			newFixedThreadPool = Executors.newFixedThreadPool(nThreads);
			while(isStartService){
				Socket socket = serverSocket.accept();
				newFixedThreadPool.execute(new ClientSocket(socket));
				synchronized (socket) {
					String clientSocketPort = socket.getPort()+"";
					System.out.println("clientSocketPort: "+clientSocketPort);
					socketPool.put(clientSocketPort, socket);	
				}
			}
		} catch (IOException e) {
			/*newFixedThreadPool.shutdown();*/
			serverSocket = null;
			//服务器关闭
		}
	}
	
	public static void main(String[] args) {
		new MainServerSocket(4478);
	}
	
}
