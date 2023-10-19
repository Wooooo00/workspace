package edu.kh.project.myPage.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MyPageMapper {

	int info(Member updateMember);

	String selectMemberPw(int memberNo);

	int changePw(Map<String, Object> map);

	int secession(int memberNo);

}

