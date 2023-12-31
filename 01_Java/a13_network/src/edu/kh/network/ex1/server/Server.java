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

// Server : 클라이언트가 이용할 서비스(코드)를 제공하는 컴퓨터
// ex) 가게 사장

// Socket : 프로세스의 양 끝 
// -> 서버 - 클라이언트를 연결하는 통로/연결고리
// -> Input/Output Stream 이용해 서버 - 클라이언트가 데이터 교환 가능

// TCP : 서버 - 클라이언트 간의 1:1 소켓 통신
//  	데이터 신뢰성을 보장(데이터 오류 시 재전송)



// TCP
public class Server {

	public void Start() {
		
		// 1. 서버의 포트 번호 정하기
		int port = 8500;
		// 포트 번호는 0 ~ 65535 사이로 지정 가능
		// 1023번 이하는 OS에서 사용하는 경우가 많으니 사용을 권장하지 않는다.
		
		// 2. 서버용 소켓 객체 생성
		// ServerSocket : 지정된 포트 번호로  
		//				: 클라이언트 연결이 되는 것을 기다리는 소켓 객체
		String ip = "192.168.10.20";
		
		ServerSocket serverSocket = null;
		
		Socket clientSocket = null; // 클라이언트와 연결되는 소켓 
		
		
		InputStream is = null; // 클라이언트 -> 서버 스트림
		OutputStream os = null; // 서버 스트림 -> 클라이언트
		
		// 성능 향상을 위한 보조 스트림
		BufferedReader br = null;
		PrintWriter pw = null;
		
		
		// 소켓, 스트림 참조 변수를 try, finally에서 모두 사용할 수 있도록 
		// try 구문 위 쪽에 참조 변수를 선언
		
		try {
			
			// 서버 컴퓨터(내 컴퓨터)의 IP 관련 정보를 얻어옴
			InetAddress inet = InetAddress.getLocalHost();
			System.out.println("서버 IP 주소 : " + inet.getHostAddress());
			
			serverSocket = new ServerSocket(port);
			
			// 3. 클라이언트가 연결 되길 기다림
			// 4. 접속 요청이 오면 해당 클라이언트에 대한 소켓 객체 생성
			
			
			System.out.println("[Server입니다]");
			System.out.println("클라이언트의 접속을 기다리고 있습니다.....");
			clientSocket = serverSocket.accept();
			
			System.out.println("[클라이언트 접속 성공]");
			
			// 5. 연결된 클라이언트와 입출력 스트림 생성
			is = clientSocket.getInputStream(); // 클라이언트 -> 서버 입력
			os = clientSocket.getOutputStream(); // 서버 -> 클라이언트 출력
			
			// 6. 보조 스트림을 통해 성능 개선
			// InputStreamReader : 바이트 -> 문자 기반 입력 스트림으로 변경 
			br = new BufferedReader(new InputStreamReader(is));
			
			pw = new PrintWriter(os);
			
		    // 7. 스트림을 통해서 읽고 쓰기
			
			// 7-1) 서버 -> 클라이언트에게 메세지 전달
			
			Date now = new Date(); // 현재 시간이 객체에 저장
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd <시간> HH:mm:ss");
			
			String message = sdf.format(now) + " [서버 접속 성공] ";
			
			pw.println(message); // 서버 -> 클라이언트로 메세지 출력 
			pw.flush(); // 스트림(버퍼)에 기록된 내용을 밀어내는 코드 
						// 미작성하면 클라이언트 쪽으로 출력되지 않아
			
			
			// 7-2) 서버 <- 클라이언트 메세지 받기(입력)
			String clientMessage = br.readLine(); // 한 줄 읽기
			
			System.out.println("클라이언트로부터 받은 메세지 : " + clientMessage);
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // try 구문에서 예외 발생 여부와 상관 없이 무조건 수행
			
			// 사용한 소켓, 스트림을 닫는 코드 작성
			// (닫다 == 메모리 반환)
			// -> 메모리 누수 관리
			
			// 보통 소켓, 스트림 생성 역순으로 보통 close() 구문을 작성
			
			try {
				// 보조 스트림(br,pw) close() 시
				// 보조 스트림 생성에 사용된 기반 스트림(is, os)도 
				// 같이 close() 된다.
				//is.close() , os.close();
	
			if(br != null)br.close();
			if(pw != null)pw.close();
			
			if(serverSocket != null) serverSocket.close();
			if(clientSocket != null) clientSocket.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
	}

}
