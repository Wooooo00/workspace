package com.kh.test.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.mapper.UserMapper;

@Service // 빈으로 등록
@Transactional

public class UserServiceiml implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public User withUserId(String inputId) {
		// TODO Auto-generated method stub
		return mapper.withUserId(inputId);
	}
	
}

