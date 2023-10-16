package edu.kh.project.myPage.controller;

import edu.kh.project.member.model.dto.Member;

// 규칙성 부여, 결합도 약화
public interface MyPageService {

	/** 
	 * 내 정보 수정 서비스
	 * @param updateMember
	 * @param memberAddress
	 * @return result( 1: 성공, 0 : 실패)
	 * */
	int info(Member updateMember, String[] memberAddress);

	int changePw(String currentPw, String newPw, int memberNo);

	int secession(int memberNo, String memberPw);
	
	// 비밀번호 변경 서비스
	// 
	
	
	
}
