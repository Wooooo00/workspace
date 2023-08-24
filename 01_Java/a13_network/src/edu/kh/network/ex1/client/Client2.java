package edu.kh.network.ex1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
	
	public void start() {
		
		String ip = "192.168.10.20";
		int port = 5000;
		Socket sc = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			System.out.println("클라이언트에요");
			sc = new Socket(ip, port);
			if(sc != null) { 
				
				is = sc.getInputStream();
				os = sc.getOutputStream();
				
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(os);
				
				String serverMessage = br.readLine();
				System.out.println(serverMessage);
				
				Scanner scan = new Scanner(System.in);
				
				System.out.println("서버로 보낼 메세지 : ");
				String clientMessage = scan.nextLine();
				
				pw.println(clientMessage);
				pw.flush();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		} try {
			
			if(br != null) br.close();
			if(pw != null) pw.close();
			if(sc != null) sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
		
	
	

}
