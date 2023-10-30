	
package com.kh.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.service.CustomerService2;

@Controller
public class CustomerController2 {
	
	@Autowired
	private CustomerService2 service;
	
	@PostMapping("insertCustomer")
	public String insertCustomer(Customer customer, Model model) {
		
		int result = service.insertCustomer(customer);
		
		if(result > 0) {
			
		}
		
		return null;
		
	}
	
}