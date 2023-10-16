package edu.kh.project.myPage.model.dao;

import java.util.Map;

import edu.kh.project.member.model.dto.Member;

public interface MyPageDAO {

	int info(Member updateMember);

	
	// 회원 비밀번호 조회
	// @param memberNo
	// @return encPw
	
	String selectMemberPw(int memberNo);
	
	// 비밀번호 변경

	int changePw(Map<String, Object> map);


	int secession(int memberNo);




	
	
	

}
