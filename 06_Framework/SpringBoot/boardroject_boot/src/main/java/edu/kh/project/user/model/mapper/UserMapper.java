package edu.kh.project.user.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.user.model.dto.User;

@Mapper

public interface UserMapper {

User selectUser(String inputId);

}
