package edu.kh.project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.project.user.model.dto.User;
import edu.kh.project.user.model.service.UserService;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;

@Controller

public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("selectUser")
	public String selectUser(String inputId, Model model) {
		
		User user = service.selectUser(inputId);
		
		if(user == null) {
			
			return "searchFail";
			
		} else {
			
			return "searchSuccess";
			
		}
			
	}
	
	request.getrequestURI();
		
}

