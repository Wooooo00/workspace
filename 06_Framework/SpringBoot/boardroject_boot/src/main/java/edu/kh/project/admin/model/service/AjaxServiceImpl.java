package edu.kh.project.admin.model.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.project.admin.model.mapper.AjaxMapper;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.mapper.MemberMapper;

@Service

public class AjaxServiceImpl implements AjaxService{
	
	@Autowired
	private AjaxMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt; // 암호화 
	
	@Autowired
	private MemberMapper memberMapper;
	
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
	
	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}
	
	// 샘플 계정 가입 
	@Override
	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		
		// 비밀번호 1234를 암호화 하여 멤버에 추가하는 작업
		member.setMemberPw( bcrypt.encode("1234"));
		
		 return memberMapper.signup(member);
	}
	
	@Override
	public int updateFlag(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.updateFlag(paramMap);
	}
}
