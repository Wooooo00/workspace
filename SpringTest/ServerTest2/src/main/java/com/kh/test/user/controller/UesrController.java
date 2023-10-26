package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.service.UserService;

@Controller
public class UesrController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("withUserNo")
	public String withUserNo(int inputNo, Model model) {
		User user = service.withUserNo(inputNo);
		
		if(user == null) { 
			return "searchFail";
			
		} else {
			
			model.addAttribute("user", user);
			return "searchSuccess";
		}

	}
	
}
	
		
		
		
	

