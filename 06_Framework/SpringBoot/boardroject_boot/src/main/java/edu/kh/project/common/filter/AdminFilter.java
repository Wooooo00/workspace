package edu.kh.project.common.filter;

import java.io.IOException;

import edu.kh.project.member.model.dto.Member;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j


	public class AdminFilter implements Filter{
	
			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
				// TODO Auto-generated method stub
				
				log.info("[[[로그인 필터 동작]]]");
				
				// 요청, 응답 객체를 HTTP 통신에 사용할 수 있는 형태로
				// 다운 캐스팅 진행
				HttpServletRequest req = (HttpServletRequest)request;
				HttpServletResponse resp = (HttpServletResponse)response;
				
				// Session 객체 얻어오기
				HttpSession session = req.getSession();
				
				// 로그인이 되어 있지 않은 경우
				// 또는 로그인은 되어 있는데 관리자 권한이 아닌 경우
				
				Member loginMember = (Member)(session.getAttribute("loginMember"));
					
				
					
				if(loginMember == null || loginMember.getAuthority() != 2) {
					
					// /loginError로 리다이렉트
					resp.sendRedirect("/adminError");
					
				} 
				
				else { // 로그인이 되어 있으면서 관리자 일 때 
					// 다음 필터 또는 DispatcherServlet으로 연결
					chain.doFilter(request, response);
				}
		
	}
		
}

