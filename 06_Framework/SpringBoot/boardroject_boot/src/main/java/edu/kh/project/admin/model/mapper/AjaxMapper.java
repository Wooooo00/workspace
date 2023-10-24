package edu.kh.project.admin.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AjaxMapper {
	
	String selectMemberNo(int memberNo);
	
	String selectEmail(String inputEmail);
	
	Member selectMember(int no);

	List<String> selectEmailList(String keyword);
	

}
