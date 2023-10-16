package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그 찍을 수 있게 만들어 주기
@Controller // Controller 역할 -> 요청, 응답을 제어 + bean으로 등록
@RequestMapping("member") // 
@SessionAttributes({"loginMember"}) // 세션에 올리기 
public class MemberController {
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
		
		return "redirect:/";
	}
}
