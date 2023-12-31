package edu.kh.project.main.model.websocket;

import java.util.Collections; 
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;


// 웹소켓 요청을 어떻게 처리할지 정의하는 클래스

// 1. TextWebSocketHandler 상속
// 2. 오버라이딩 
/* afterConnectionEstablished
   handleTextMessage
   afterConnectionClosed */
// 3. bean 등록 (스프링이 알아서 객체로 만들고 상황에 맞게 동작)

@Component // bean 등록 (@Controller, @Service의 부모 어노테이션)

@Slf4j

public class TestWebSocketHandler extends TextWebSocketHandler{
	
	// WebSocketSession : 클라이언트 - 서버 전이중 통신을 담당하는 객체
	//						이 객체로 클라이언트의 세션을 다룰 수 있다.
	// sessions : 클라이언트 세션을 모아둔 set으로 지정
	// 			-> 모든 사용자, 원하는 사용자 찾기 가능		
	// synchronizedSet : 동기화된 Set(안전성 증가)
	
	
	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>()); 
	
	
	// 클라이언트 연결이 완료 되고 통신할 준비가 될 때 수행
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
//		super.afterConnectionEstablished(session);
		
		// 매개변수 session == 한 명의 클라이언트
		sessions.add(session); // 필드에 있는 set에 매개변수 session 추가
		// -> 누가 접속했는지 set을 이용하여 파악 가능한다(명단 생성)
	}
		
		@Override
		protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
			// TODO Auto-generated method stub
//			super.handleTextMessage(session, message);
			
			// Payload : 전달 받은 데이터
			
			log.debug("전달받은 내용 : " + message.getPayload());
			
			// 전달 받은 데이터를 접속한 모든 사용자에게 보내기
			// 접속한 모든 사용자에게 보내기
			
			// 특정 클라이언트 메세지 -> 서버 -> 모든 클라이언트
			
			for(WebSocketSession s : sessions) {
				s.sendMessage(message);
			}
			
		}
	
	// 클라이언트 연결이 종료 될 때 수행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		// 나간 클라이언트 set에서 제거(명단에서 제외)
		sessions.remove(session);
//		super.afterConnectionClosed(session, status);
	}
	

}
