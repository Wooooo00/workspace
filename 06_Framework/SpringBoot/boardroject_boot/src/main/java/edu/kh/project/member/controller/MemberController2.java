package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

// Spring Boot Controller에서 요청 주소 작성 시
// 제일 앞에 "/" 제외하고 작성
// 

@Slf4j // 로그 찍을 수 있게 만들어 주기
@Controller // Controller 역할 -> 요청, 응답을 제어 + bean으로 등록
@RequestMapping("member") // 
@SessionAttributes({"loginMember"}) // 세션에 올리기 
public class MemberController2 {
	// MemberService 의존성 주입
	@Autowired 
	private MemberService service;
	
	// 로그인 
	// inputMember : 아이디, 비밀번호 파라미터
	// 
	// 
	// 
	@PostMapping("login") // /member/login(POST)
	public String login(Member inputMember, Model model, RedirectAttributes ra) {
		
		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);

		// 로그인 성공 시
		if(loginMember != null) {
			
		}
		
		// 로그인 실패 시
		if(loginMember == null) {
			ra.addFlashAttribute("Message", "아이디 혹은 비밀번호가 일치하지 않습니다");
			
		}
		
		model.addAttribute("loginMember", loginMember);
		
		// 메인 페이지 리다이렉트
		return "redirect:/";
	}
	
		@GetMapping("logout")
		public String logout(SessionStatus status) {
			status.setComplete(); // 세션 만료
			return "redirect:/";
		}
		
		// 로그인 전용 페이지 forward
		
		@GetMapping("login")
		public String login() {
			return "member/login";
			
		}
	
		
		@GetMapping("signup")
		public String signup() {
			return "member/signup";
		}
		
		// 멤버 필드에 
		// @param inputMember : 파라미터가 저장된 커맨드 객체
		// @param memberAddress : 주소 입력값이 저장된 배열 가공 해주어야 한다
		// RedirectAttributes ra : redirect 할 때 request scope로 값을 전달해준다 
		
		
		@PostMapping("signup")
		public String signup(Member inputMember, String[] memberAddress, RedirectAttributes ra) {
			
			
			// 회원 가입 서비스 호출
			int result = service.signup(inputMember, memberAddress);
			
			// 회원 가입 성공
			if(result > 0) {
				ra.addFlashAttribute("message", "회원 가입 성공");
				return "redirect:/"; // 메인 페이지로 리다이렉트
			}
			
			// 회원 가입 실패
			
			ra.addFlashAttribute("message", "가입 실패");
			return "redirect:signup";
		}
		
		
		
		// @PathVariable("key") 값
		// 경로(주소)를 변수의 값으로 사용하는 어노테이션
		
		// 빠른 로그인(프로젝트 완성 후 삭제)
			
		
		// memberEmail : 주소 마지막 레벨 문자열(Pathvariable)
		// model : 데이터 전달용 객체
		// ra : 리다이렉트 시 request scope로 데이터 전달
		@GetMapping("login/{memberEmail}")
		public String quickLogin(@PathVariable("memberEmail") String memberEmail, 
				Model model, RedirectAttributes ra) {
			
			Member loginMember = service.quickLogin(memberEmail);
			
			if(loginMember == null) {
				ra.addFlashAttribute("message", "빠른 로그인 실패");
			}
			
			// 기본값 request scope
			// @SessionAttributes({"loginMember"}) -> session scope 이동
			model.addAttribute("loginMember", loginMember);
			
			
			
			
		
			
			return "redirect:/";
			
		}
		
		
		
	}

