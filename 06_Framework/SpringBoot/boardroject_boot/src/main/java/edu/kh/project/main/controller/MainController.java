package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 현재 클래스에서 로그 출력 시 작성하는 어노테이션
@Controller
public class MainController {
	
	@RequestMapping("/") // GET / POST 가리지 않고 "/" 요청이 오면 맵핑
	public String mainPage(Model model) {
		
			// Model : 데이터 전달용 객체(기본 scope : request)
			model.addAttribute("testName", "홍길동");
			model.addAttribute("testAge", "25");
			
			
			
			Member testMember = new Member();
			testMember.setMemberNo(88888);
			testMember.setMemberEmail("testMember@naver.com");
			testMember.setMemberNickname("김테스트");
			
			model.addAttribute("testMember", testMember);
			
			// text, utext 비교
			model.addAttribute("address", "<h1>서울시 강남구<h1>");
			
			// 로그 출력 방법
			// log.debug("문자열");
		
			log.debug("로그는 이렇게 찍을 수 있습니다");
			log.debug("메인 페이지 요청이 왔습니다");
			
			// * Thymeleaf 템플릿 엔진 사용 시 접두사, 접미사 
			// 접두사 : classpath:/templates/
			// 접미사 : .html
			
			// classpath == src/main/resources 
			return "common/main";
	}
	
	@GetMapping("loginError")
	public String loginError(RedirectAttributes ra) {
		ra.addFlashAttribute("message", "로그인 후 이용해주세요");
		return "redirect:/";
	}
	
	
	/** 관리자 권한이 없는 상태에서 관리자 페이지 접근 시
	 * @param ra
	 * @return
	 */
	@GetMapping("adminError")
	public String adminError(RedirectAttributes ra) {
		ra.addFlashAttribute("message", "정상 접근이 아닙니다");
		return "redirect:/";
	}
	
	
			

}
