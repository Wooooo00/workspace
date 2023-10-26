package edu.kh.project.admin.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AjaxMapper {
	
	String selectMemberNo(int memberNo);
	
	String selectEmail(String inputEmail);
	
	Member selectMember(int no);

	List<String> selectEmailList(String keyword);

	List<Member> selectAll();

	int insertMember(Member member);

	int updateFlag(Map<String, Object> paramMap);
	

}
