package edu.kh.project.admin.model.service;

import java.util.List;

import edu.kh.project.member.model.dto.Member;


public interface AdminService {
	
	
	Member selectMember(String inputEmail);

	
	/**
	 * 
	 */
	
	List<Member> selectAll();


	List<Member> selectSort(int sort);


	int restoration(int memberNo);

	
	int changeAuthority(int memberNo);


	int initPw(int memberNo);


	
	
	

	



	

}
