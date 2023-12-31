package edu.kh.project.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import edu.kh.project.member.model.service.MemberServiceImpl;

/**
 * @author user1
 *
 */
@Controller // 요청/응답을 처리하는 클래스

@RequestMapping("/member") // 요청 연결 // 클래스 위에 작성하면 공통 주소(/member로 시작하는 주소)
@SessionAttributes({"loginMember"})

public class MemberController {
	
	// 등록된 bean 중 MemberServiceImpl을 해당 필드에 의존성 주입
	
	
	@Autowired
	private MemberService service;
	
	
	//@RequestMapping(value="/login", method = RequestMethod.POST)
//	public String login(HttpServletRequest req) {
//		
//		/* - Argument Resolver(매개 변수 확인자) 
//		 * 매개변수에 원하는 타입을 선언하면 
//		 * 해당 타입 객체를 얻어오거나 생성할 수 있다.
//		 * 
//		 * 
//		 *  */
//		String email = req.getParameter("memberEmail");
//		String pw = req.getParameter("memberPw");
//		
//		System.out.println(email);
//		System.out.println(pw);
//				
//		return null;
//	}
	
	// Spring에서 파라미터를 전달 받는 방법2
	// -> @RequestParam 어노테이션 이용
	
//	@PostMapping("/login") // @RequestMapping의 POST 버전
//	public String login(@RequestParam("memberEmail") String email
//			,String memberPw
//			,@RequestParam(value = "inputName", required = false, defaultValue = "미입력") String name
//			,@RequestParam Map<String, Object> paramMap) {
//		
//		System.out.println("email : " + email);
//		System.out.println("memberPw : " + memberPw);
//		System.out.println("name : " + name);
//		System.out.println("paramMap : " + paramMap);
//		System.out.println(paramMap.get("memberEmail"));
//		System.out.println(paramMap.get("memberPw"));
		
		/* @RequestParam 
		 * -> request 객체를 이용한 파라미터 전달 어노테이션
		 * -> 요청 파라미터 얻어오는 어노테이션
		 * 1) 매개 변수 앞에 해당 어노테이션을 작성
		 * ex) RequestParam("memberEmail") String email
		 * -> 파라미터 중 key가 memberEmail인 밸류를 매개변수 email에 대입
		 * 
		 * 2) @RequestParam을 생략
		 * 매개변수 변수명이 파라미터의 key값과 같으면 생략 가능
		 * ex) String memberPw;(== name="memberPw") 
		 * 
		 * 3) @RequestParam(속성)
		 * -> 필기 참고
		 * 
		 * 4) @RequestParam() 괄호 생략 
		 * -> Map 형식으로 모든 파라미터를 얻어옴
		 * ex) @RequestParam Map<String,Object> paramMap
		 * 
		 * */
		
		
	//	return null;
//	}
	
	// Spring에서 파라미터를 전달 받는 방법 3 
	// -> @ModelAttribute 어노테이션 이용
	
	//@PostMapping("/login")
	
	// @ModelAttribute -> 파라미터 전달 받기
	
	public String login( @ModelAttribute Member member) {
		
		/* @ModelAttribute 
		 * - DTO와 같이 사용하는 어노테이션
		 * - DTO의 필드명과 파라미터 key가 같으면 
		 *   DTO 객체 필드에 자동으로 set (setter 필요)
		 *   주의 사항
		 *   DTO에 기본 생성자 필수로 꼭 작성!!
		 *   DTO에 setter 꼭 작성!! 
		 *   
		 *   1) @ModelAttribute 사용
		 *   
		 *   2) @ModelAttribute
		 *   
		 *   @ModelAttribute로 인해서 필드에 값이 세팅된 객체를 [커맨드 객체]라고 한다.
		 * */
		
		
		System.out.println(member);
		
		System.out.println(member.getMemberEmail());
		System.out.println(member.getMemberPw());
		return null;
	}
	
	// ---------------------------------------------------------------------------------
	
	
	/** 로그인 요청 처리
	 * <p>
	 * 로그인 요청 처리(세션) + 아이디 저장(쿠키)
	 * </p>
	 * @Param inputMember : 이메일, 비밀번호 저장 커맨드 객체
	 * @Param model : 데이터 전달용 객체
	 * @param ra: 리다이렉트 시 데이터를 request scope로 전달하는 객체
	 * @return
	 */
	
	@PostMapping("login")
	public String login(Member inputMember
			, Model model,
			RedirectAttributes ra) {
		
		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);
		// 로그인 성공 : Member 객체 반환
		// 로그인 실패 : null 반환
		
		
		/* Spring에서 Session을 다루는 방법
		 * 1) Model 객체 + @SessionAttributes 
		 * 
		 * */
		
		// 데이터 전달 객체에 속성 추가
		// 
		model.addAttribute("loginMember", loginMember);
		
		// -------------------------------------------------------------------------
		// 로그인 실패 시 특정 메세지를 **잠깐** session에 세팅하여 
		// 메인 페이지에서 alert()로 출력해보기
		
		// *잠깐* session에 세팅하는 이유 : 
		// 1) redirect 시 request scope 사용 불가
		// 2) session에 계속 있으면 계속 메세지가 출력 되기 때문에
		
		/* RedirectAttributes  */
		// 값 세팅 시 request scope
		// redirect 중 : session scope로 이동
		// redirect 완료 후 : request scope로 돌아온다
		
		// 작성법 1 
		// RedirectAttributes를 메서드 매개변수에 추가
		// RedirectAttributes.addFlashAttribute("key", value)
		
		if(loginMember == null) {
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다");
		}
		
		// 작성법 2
		// 
		
		// Spring에서 redirect 하는 방법
		// return "redirect : 요청 주소";
		
		
		return "redirect:/";
	}
	
	@GetMapping("logout")
	public String logout(SessionStatus status) {
		
		// SessionStatus : @SessionAttributes를 이용해 
		// Session scope에 등록된 값을 정리 할 수 있는(없앨 수 있는 객체)
		
		// 세션 만료(세션 제거) 
		status.setComplete();
		
		return "redirect:/";
	}
	
	/** 회원 가입 화면 전환
	 *  
	 * */
	@GetMapping("signup")
	public String signup() {
		// WEB_INF/views/member/signup.jsp로 forward
		
		return "member/signup";
		
	}
	
	/** 회원 가입 진행
	 * 
	 * @return
	 */
	@PostMapping("signup")
	public String signup(Member inputMember,
			@RequestParam("memberAddress") String[] memberAddress) {
		
		// 회원 가입 서비스 호출 후 결과(insert 행의 개수) 반환 받기
		int result = service.signup(inputMember, memberAddress);
		
		System.out.println("result : " + result);
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
}
