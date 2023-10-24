package edu.kh.project.admin.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.admin.model.mapper.AjaxMapper;
import edu.kh.project.member.model.dto.Member;

@Service

public class AjaxServiceImpl implements AjaxService{
	
	@Autowired
	private AjaxMapper mapper;
	
	@Override
	public String selectMemberNo(int memberNo) {
		// TODO Auto-generated method stub
		return mapper.selectMemberNo(memberNo);
	}

	@Override
	public String selectEmail(String inputEmail) {
		// TODO Auto-generated method stub
		return mapper.selectEmail(inputEmail);
	}
	
	@Override
	public Member selectMember(int no) {
		// TODO Auto-generated method stub
		return mapper.selectMember(no);
	}
	
	@Override
	public List<String> selectEmailList(String keyword) {
		// TODO Auto-generated method stub
		return mapper.selectEmailList(keyword);
	}
}
