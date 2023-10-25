package com.kh.test.controller;

import java.io.IOException;

import org.apache.catalina.connector.Response;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("orderProduct.do")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터		
		String name = req.getParameter("name");
		String blackpen = req.getParameter("blackPen");
		String redpen = req.getParameter("redPen");
		String bluepen = req.getParameter("bluePen");
		String White = req.getParameter("white");

		
		
		
		// 가공
		int result = 0;
		int price = 0;
		switch(pen) {
		case "검정펜" : price = 500; break;
		case "빨간펜" : price = 700; break;
		case "파란펜" : price = 700; break;
		case "화이트" : price = 1000; break;
		}
		
		resp.setContentType("text/html; charset=UTF-8");
		
		out.print("<!DOCTYPE html>"
				+ "<html lang=\"en\">"
				
				+ "   <h3>"+name+"님 주문 결과</h3>"
				+ "<body>"
				+ "   <h3>검은펜 </h3>"
				+ "   <h3>빨간펜 </h3>"
				+ "   <h3>파란펜 </h3>"
				+ "   <h3>화이트</h3>"
				+ "   <hr><hr>"
			
				+ "   <h3>총합 :  원을 결제하셨습니다.</h3>");
				
		
		
		// total 0 아님 포워드
		
		if(result > 0) {
			
		RequestDispatcher.forward()
			
		}
		
		
		
		// total 0이면 error.do로 리다이렉트
		HttpServlet.sendRedirect("error.do");
	}
}
