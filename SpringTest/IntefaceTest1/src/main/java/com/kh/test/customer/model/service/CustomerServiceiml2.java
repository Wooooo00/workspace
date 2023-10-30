package com.kh.test.customer.model.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.customer.model.mapper.CustomerMapper2;

@Service
public class CustomerServiceiml2{
	
	@Autowired
	private CustomerMapper2 mapper;
	


}