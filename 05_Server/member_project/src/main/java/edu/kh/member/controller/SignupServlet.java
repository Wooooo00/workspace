package edu.kh.member.controller;

import java.io.IOException;

import edu.kh.member.model.dto.Member;
import edu.kh.member.model.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{

	// get 방식 요청 시 signup.jsp로 응답(회원가입 화면 보여주기)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/signup.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// POST 방식 요청 문자 인코딩 변경
		req.setCharacterEncoding("UTF-8");
		// 파라미터 모두 얻어와 Member 객체에 저장
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		
		Member member = new Member();
		
		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		member.setGender(gender);
		
		// 회원 가입 서비스 호출 후 결과 반환 받기
		MemberService service = new MemberService();
		
		int result = service.signup(member);
		
		String message = null;
		
		if(result > 0) message = "회원가입 성공!";
		else		   message = "가입 실패";
		
		
		//req.setAttribute("message", message);
		// -> redirect 시 req가 삭제 되어 message를 사용 못 한다.
	
		// -> request scope보다 넓은 범위의 객체에 속성 추가하여 
		// 문제를 해결할 수 있다!
		HttpSession session = req.getSession();
		session.setAttribute("message", message);
			
		// 메인 페이지 재요청(redirect)
		// -> 
		resp.sendRedirect("/");
		
	}
}
