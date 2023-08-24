package edu.kh.network.ex2.thread;

import java.io.DataInputStream;
import java.net.Socket;

// 데이터를 수신(입력) 작업을 처리하는 스레드
public class Receiver implements Runnable {

	// 필드
	private DataInputStream in = null; // sender가 보낸 데이터를 입력받을 스트림
	
	// 생성자
	public Receiver(Socket socket) {
		try {
			in = new DataInputStream(socket.getInputStream());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				System.out.println(in.readUTF());
				
			} catch(Exception e) {
				//  서버 또는 클라이언트 종료 시 입력 받을 수 없게 되면 예외가 발생
				break; // while문 종료
				
			}
		}
	}
	
	
	

}
