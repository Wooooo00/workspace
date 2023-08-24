package edu.kh.network.ex2.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import edu.kh.network.ex2.thread.Receiver;
import edu.kh.network.ex2.thread.Sender;

public class ChatiingClient {
	
	public static void main(String[] args) {
		ChatiingClient client = new ChatiingClient();
		client.start();
	}

	void start() {
		Scanner sc = new Scanner(System.in);
		
		// 1. ip, port 입력 받기
		System.out.print("접속할 IP : ");
		String serverIP = sc.next();
		
		System.out.print("포트 번호 : ");
		int port = sc.nextInt(); 
		sc.nextLine(); // 입력 버퍼에 남아있는 개행 문자 제거
		
		Socket socket = null;
		
		try {
			// 2. 서버 접속
			// 실패 시 UnknownHostException 발생
			socket = new Socket(serverIP, port);
						
			
			//서버 접속 성공
			if(socket != null) {                 
				System.out.println("<서버 접속 성공>");
				System.out.print("클라이언트 이름 입력 : ");
				String clientName = sc.nextLine();
		
				Sender sender = new Sender(socket, clientName);
				// 클라이언트 -> 서버 입력 역할하는 객체 생성
				Receiver receiver = new Receiver(socket);
				// 스레드로 생성
				Thread th1 = new Thread(sender);
				Thread th2 = new Thread(receiver);
				
				th1.start();
				th2.start();
				
				th1.join();
				th2.join();				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally { 
			// 메모리 누수 관리
			try {
			
				if(socket != null)socket.close();			
			
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
		
	}

}
