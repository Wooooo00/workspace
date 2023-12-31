package edu.kh.project.admin.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.member.model.dto.Member;

/**
 * 
 */
public interface AjaxService {

	String selectMemberNo(int memberNo);

	String selectEmail(String inputEmail);

	Member selectMember(int no);

	List<String> selectEmailList(String keyword);

	List<Member> selectAll();

	int insertMember(Member member);

	int updateFlag(Map<String, Object> paramMap);

}
