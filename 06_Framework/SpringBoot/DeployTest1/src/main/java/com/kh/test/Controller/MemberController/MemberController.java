package com.kh.test.Controller.MemberController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	
	@PostMapping("loginTest")
	public String loginTest(@RequestParam("id") String id, 
							@RequestParam("pw") String pw, Model model) {
		
		
		// 모델로 데이터(메세지) 넘길 건데 결과
		//model.addAttribute("", );	
				
		if(id.equals("user01") && pw.equals("pass01")) {
			model.addAttribute("message", "성공");					
			return "loginResult";
		}
		
		else {
			model.addAttribute("message", "실패");
			return "loginResult";
		}
		
	}
	
}
