package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//	@WebServlet("/login") 현재 클래스를 Servlet으로 등록 & /login에 매핑
@WebServlet("/login")
public class Error extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// !! POST 방식으로 전달된 데이터 중 
		// 영어, 숫자, 기본 특수 문자가 아니면
		// 톰캣 버전에 따라 깨지는 문제가 발생할 수 있다
		// 따라서 요청 데이터의 문자 인코딩을 변경하여 문제를 해결 가능!
		
		req.setCharacterEncoding("UTF-8"); // 문자 인코딩 변경 구문 
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		System.out.print("id");
		System.out.print("pw");
		System.out.print("name");
		
		
		
		// 
	}	
}
 


  
