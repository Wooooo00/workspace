package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 객체 : new 연산자에 의해서 class 내용대로 heap 영역에 생성된 것(할당된 메모리)  
// bean : 객체(스프링(Spring container)이 만들고 관리한다)
// instance : 개발자가 만들고 관리하는 객체
@Controller // Bean 등록 + Controller 역할도 수행할 것이라고 명시
			// Controller의 역할 : 요청 / 응답 제어 


public class MainController {

	@RequestMapping("/")
	public String mainPage() {
		
		return "common/main";
		// -> /WEB-INF/views/common/main.jsp로 포워드
	}
	
}




