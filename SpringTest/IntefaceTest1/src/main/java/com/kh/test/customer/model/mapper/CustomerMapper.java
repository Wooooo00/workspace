package com.kh.test.customer.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.kh.test.customer.model.dto.Customer;

// 매퍼로 선언
@Mapper
public interface CustomerMapper {
	
	int insertCustomer(Customer customer);

}
