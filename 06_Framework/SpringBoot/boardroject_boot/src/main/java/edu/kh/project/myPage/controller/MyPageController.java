package edu.kh.project.myPage.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.service.MyPageService;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

/**
 * 
 */
@Controller
@RequestMapping("myPage")
@SessionAttributes({"loginMember"})
@Slf4j

public class MyPageController {
	@Autowired
	private MyPageService service;
	
	// 마이 페이지 화면 전환(4wd)
	
	@GetMapping("info") //myPage/info
	public String info() {
		
		// templates/myPage/myPage-info.html 접두사 접미사 제거한 나머지 부분 
		return "myPage/myPage-info";
	}
	
	@GetMapping("profile") //myPage/info
	public String profile() {

		return "myPage/myPage-profile";
	
	}
	
	@GetMapping("changePw") 
	public String changePw() {

		return "myPage/myPage-changePw";
	
	}
	
	@GetMapping("secession") 
	public String secession() {

		return "myPage/myPage-secession";
	
	}
	
	
	/** 회원 정보 수정
	 * @param updateMember : 수정된 회원 정보가 담긴 커맨드 객체
	 * @param memberAddress : 주소값이 담긴 배열
	 * @param SessionAttribute : 현재 로그인한 회원의 정보가 담긴 객체(세션)
	 * @param ra : 리다이렉트 했을 때 request scope로 데이터 전달
	 * 
	 * 
	 * 
	 * @return
	 * 
	 */
	@PostMapping("info")
	public String info(Member updateMember, String[] memberAddress,
			@SessionAttribute("loginMember") Member loginMember, RedirectAttributes ra) {
		
		// 1. loginMember에서 회원 번호만 얻어와서 updateMember에 세팅
		updateMember.setMemberNo( loginMember.getMemberNo() );
		
		// 2. 회원 정보 서비스 호출 
		
		int result = service.info(updateMember, memberAddress);
		
		// 3. 서비스 결과에 따라 응답 제어
		
		String message = null;
		// 성공 했을 때
		// - message = "회원 정보가 수정 되었습니다"
		// - session에 세팅된 이전 회원 정보를
		//  	수정된 회원 정보로 다시 세팅
		
		if(result > 0) { 
			
			message = "회원 정보가 수정 되었습니다";
			loginMember.setMemberNickname(updateMember.getMemberNickname());
			loginMember.setMemberTel(updateMember.getMemberTel());
			loginMember.setMemberAddress(updateMember.getMemberAddress());
		} else { 
			
			message = "수정 실패";
		}
		
		ra.addFlashAttribute("message", message);
		
		// 로그인 실패 시
		
		// 실패 
		// - message = "회원 정보 수정 실패"

		return "redirect:info";
	}
	
		
	// 
	
		@PostMapping("changePw")
		public String changePw(String currentPw, String newPw,
				@SessionAttribute("loginMember") Member loginMember, RedirectAttributes ra) {
			
			
			
			int result = service.changePw(currentPw, newPw, loginMember.getMemberNo());
			
			String message = null;
			String path = null;
			// bcryptmatch 
			
			if(result>0) {
				message = "변경 완료";
				path = "redirect:info";
			} else {
				message = "변경 완료";
				path = "redirect:changePw";
			}
			
			ra.addFlashAttribute("message", message);
			return path;
		
		}
		
		@PostMapping("secession")
		public String secession(String memberPw,
				@SessionAttribute("loginMember") Member loginMember, RedirectAttributes ra, SessionStatus status) {
			
			int result = service.secession(memberPw, loginMember.getMemberNo());
			String message = null;
			String path = null; 
			
			if(result>0) {
				message = "탈퇴 완료";
				path = "redirect:/";
			    status.setComplete();
			
			} else {
				message = "비밀번호가 맞지 않습니다";
				path = "redirect:secession";
			}
			
			ra.addFlashAttribute("message", message);
			
			return path;
		}
	
		
		// -------------------------------------------------
			
		// MultipartFile : multipart / form - data 형식으로 제출된 파라미터 중
		// 					file 타입 데이터만 추출해 저장하는 Spring 제공 객체
		// - 실제 파일
		// - 파일 이름
		// - 파일 크기
		// - 업로드 된 파일을 지정된 경로에 저장하는 메서드
		//	(추가 설정 필요!)
		// 프로필 이미지 수정
		
		/** 
		 * @param profileImg : 실제 업로드 된 프로필 이미지
		 * @return
		 * @throws IOException 
		 * @throws IllegalStateException 
		 */
		
		@PostMapping("profile")
		public String profile(
				@RequestParam("profileImg") MultipartFile profileImg,
				@SessionAttribute("loginMember") Member loginMember,
				RedirectAttributes ra) throws IllegalStateException, IOException {
			
				// 프로필 이미지 수정 서비스 호출 후 결과 반환
				int result = service.profile(profileImg, loginMember); 
				
				String message = null;
				
				if(result > 0) {
					message = "프로필 이미지가 변경";
					
				} else {
					
					message = "프로필 변경 실패!";
					
				}
				
				ra.addFlashAttribute("message", message);
				//   실제 이미지 파일, 세션에 저장된 회원 정보
				return "redirect:profile";
		}
		
	
}
