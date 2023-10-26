package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.service.UserService;

@Controller
public class UesrController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("withUserId")
	public String withUserId(String userId, Model model) {
		
		User withUser = service.withUser(userId);
		
		if(withUser != null) {
			model.addAttribute("withUser", withUser);
			
			return "/withUserId";
		
		
		
	
	

	

}





