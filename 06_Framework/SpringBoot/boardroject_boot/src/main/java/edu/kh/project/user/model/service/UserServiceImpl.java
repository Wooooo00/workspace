package edu.kh.project.user.model.service;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.user.model.dto.User;
import edu.kh.project.user.model.mapper.UserMapper;


@Service

public class UserServiceImpl implements UserService {

@Autowired
private UserMapper mapper;

	@Override
	public User selectUser(String inputId) {
		// TODO Auto-generated method stub
		return mapper.selectUser(inputId);
	}
	
}
