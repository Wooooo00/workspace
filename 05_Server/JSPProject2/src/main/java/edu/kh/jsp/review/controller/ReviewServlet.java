package edu.kh.jsp.review.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
// 톰캣(WAS)에서 제공하는 클래스
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//Servlet으로 등록 
// 클라이언트의 요청 주소를 처리할 클래스를 매핑(연결)
@WebServlet("/review")
public class ReviewServlet extends HttpServlet{
	
	// doGet(req,resp) : GET 방식 요청 처리 메서드
	// HttpServletRequest : 클라이언트의 요청 정보(파라미터, ip)
    //						
	// HttpServletResponse : 서버 -> 클라이언트 응답하는 방법을 제공
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String req.getParameter("name 속성값") : 파라미터값 얻어 오기
		
		String inputName = req.getParameter("inputName");
		String inputAge = req.getParameter("inputAge");
		String gender = req.getParameter("gender"); 
		
		// 체크박스처럼 여러 개를 선택할 수 있는 경우에는 String 배열 형식으로 받아야한다!!
		// String[] req.getParameterValues("네임속성값") : 파라미터 모두 얻어오기
		
		String[] hobbyArr = req.getParameterValues("hobby");
		
		// hobbyArr의 값이 있을 때, 없을 때에 따라 알맞은 문자열을 생성 
		// 있을 때 : ex) 취미는 게임, 유튜브입니다. 
		// 없을 때 : ex) 선택된 취미가 없습니다. 
		
		// 체크된 값이 없으면 -> null 
		
		String str = null;
		if(hobbyArr == null) {
			str = "선택된 취미가 없습니다";
		} else { 
			// 스태틱 
			str = String.format("취미는 %s입니다.", String.join(",", hobbyArr));
		}
		
		// ----------------------------------------------------------------------
		// JSP에 요청 위임(JSP에게 응답 화면을 대신 만들어 달라고 요청) 

		// JSP 파일 경로 작성(Webapp 폴더 기준)
		String path = "/WEB-INF/views/review_result.jsp";
		
		// 요청 발송자 얻어오기
		// RequestDispatcher dispatcher = req.getRequestDispatcher("JSP 파일 경로");
		
	
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		// Servlet에서 생성한 변수(str)을
		// 요청 위임된 JSP에서 사용할 수 있도록
		// HTTPServletRequest에 속성(필드)로 추가
						// K, V 
		req.setAttribute("str", str);
		
		// 요청 위임(forward) 수행
		
		dispatcher.forward(req,resp);
		
	}
}








