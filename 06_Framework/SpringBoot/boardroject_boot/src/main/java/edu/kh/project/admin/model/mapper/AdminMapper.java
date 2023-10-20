package edu.kh.project.admin.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AdminMapper {

	
	Member selectMember(String inputEmail);

	// Mapper 메서드의 반환형이 List로 작성되어 있으면
	// 마이바티스 수행 시 조회되는 모든 행을 
	// 자동으로 List에 추가
	// 단, 조회 결과가 없을 경우 비어 있는 List (0칸) 
	List<Member> selectAll();

	// 전체 회원 조회 + 정렬 기능이 추가
	
	List<Member> selectSort(String query);

	int restoration(int memberNo);

	int changeAuthority(int memberNo);

	int initPw(Map<String, Object> map);
	
	
	

	

}
