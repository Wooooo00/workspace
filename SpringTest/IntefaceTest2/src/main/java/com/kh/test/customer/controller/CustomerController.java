package com.kh.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("searchCustomer")
	public String searchCustomer(Customer customer, Model model) {
		
		
		int result = service.searchCustomer(customer);
			
		if(result > 0) {
			
			model.addAttribute("message", "변경 성공");
		
		} else {
			
			model.addAttribute("message", "변경 실패");
			
		} 
		  
			return "result";
		
		
	}
	
	
}
