package com.kh.test.customer.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.kh.test.customer.model.dto.Customer;

import com.kh.test.customer.model.mapper.CustomerMapper;

@Service
// 서비스 선언 빈 생성

// Customer Service 상속
public class CustomerServiceiml implements CustomerService {

// Mapper 상속 
@Autowired

	private CustomerMapper mapper;


@Override
// insertCustomer 객체 오버라이딩
public int insertCustomer(Customer customer) {

// insertCustomer(customer)에 들어간 값을 맵퍼에 저장
	return mapper.insertCustomer(customer);

	}

}