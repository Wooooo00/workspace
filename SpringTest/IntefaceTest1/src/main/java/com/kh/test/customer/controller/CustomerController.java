	
package com.kh.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;

import com.kh.test.customer.model.dto.Customer;

import com.kh.test.customer.model.service.CustomerService;

// 컨트롤러로 지정
@Controller

public class CustomerController {

	// CustomerService 의존성 주입
	@Autowired

	private CustomerService service;

	// insertCustomer 메서드가 Post이므로 포스트 맵핑 
	@PostMapping("insertCustomer")

		// 파라미터로 DTO인 customer와  
		public String insertCustomer(Customer customer, Model model) {
	
			// insertCustomer에 들어간 customer 값을 서비스 호출
		int result = service.insertCustomer(customer);
	
		// 결과가 0보다 크다면 
		if(result > 0) model.addAttribute("message", "추가 성공!!!");
	
		else model.addAttribute("message", "추가 실패...");
	
		// result 요청 위임
		return "result";

	}

}