package com.serversocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.shop.bean.SocketOOP;

public class ClientReadThread implements Runnable{
	private Socket socket;
	private InputStream inputStream;
	private ObjectInputStream objectInputStream;
	public ClientReadThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			inputStream = socket.getInputStream();
			if(inputStream==null){
				return;
			}
			objectInputStream = new ObjectInputStream(inputStream);
			SocketOOP socketOOP = null;
			while((socketOOP = (SocketOOP) objectInputStream.readObject())!=null){
				//解析数据，并写入数据库中
			}
		}catch(Exception e){
			try {
				if(inputStream!=null){
					inputStream.close();
				}
				if(objectInputStream!=null){
					objectInputStream.close();
				}
			} catch (IOException e1) {
				//e1.printStackTrace();
			}
		}
	}
}
