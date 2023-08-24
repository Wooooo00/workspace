package edu.kh.network.ex1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server2 {
	
	public void Start() {
		
		int port = 5000;
		String ip = "192.168.10.20";
		ServerSocket svs = null;
		Socket cs = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		// 보조 스트림 
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			InetAddress ia = InetAddress.getLocalHost();
			System.out.println("서버 IP 주소" + ia.getHostAddress());
			
			svs = new ServerSocket(port);
			
			System.out.println("서버입니다");
			System.out.println("클라이언트의 접속을 기다리는 중");
			cs = svs.accept();
			
			System.out.println("클라이언트 접속 성공");
			
			is = cs.getInputStream();
			os = cs.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os);
			
			Date now = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			
			String message = sdf.format(now) + "<지금 시간은>";
			
			pw.println(message);
			pw.flush();
			
			String clientMessage = br.readLine();
			System.out.println("클라이언트로부터 온 메세지 : " + clientMessage);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(svs != null) svs.close();
				if(cs != null) cs.close();
				if(br != null) br.close();
				if(pw != null) pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
 			

		
		
		
		
		
		
		
	}
	
	
	
	
		// 서버 
		
		/*  1. 서버 포트 번호 지정 
		 *  2. 서버용 소켓 객체 생성 
		 *  3. 클라이언트와 서버를 연결 시켜주는 소켓 생성
		 *  4. 클라이언트 -> 서버(인풋 스트림)
		 *          서버 -> 클라이언트(아웃풋 스트림)를 연결 시켜주는 스트림을 입력
		 *  5. 보조 스트림 생성 
		 *  소켓, 스트림의 참조 변수를 try,finally에서 사용 가능하도록 
		 *  try 구문 위 쪽에 작성한다. 
		 *  
		 *  트라이 구문 안에 서버 컴퓨터의 IP 관련 정보를 얻어온다.
		 *  클라이언트 연결 대기
		 *  접속 요청이 오면 해당 클라이언트에 대한 소켓 객체 생성.
		 *  
		 *  연결된 클라이언트와 입출력 스트림을 생성한다. 
		 *  .getInputStream & .getOutputStream 
		 *  
		 *  
		 *  
		 * 
		 */
		
		// 클라이언트
		
		/* 1. 서버의 IP 주소와 서버가 지정한 포트 번호를 이용하여
		 * 서버와 연결하는 소켓 객체를 생성
		 * 
		 * 
		 * 
		 */
				

}
