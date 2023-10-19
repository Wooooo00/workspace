package edu.kh.project.admin.model.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.project.admin.model.mapper.AdminMapper;
import edu.kh.project.member.model.dto.Member;
@Service
public class AdminServiceImpl implements AdminService {
	
	
	@Autowired
	private AdminMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;   
	
	@Override
	public Member selectMember(String inputEmail) {
		// TODO Auto-generated method stub
		return mapper.selectMember(inputEmail);
	}
	
	@Override
	public List<Member> selectAll() {
		
		return mapper.selectAll();
	}

	@Override
	public List<Member> selectSort(int sort) {
		// TODO Auto-generated method stub
		
		// sort 값에 따라서 가공 처리
		String query = null;
		
		switch(sort) {
		case 1 : query = "MEMBER_NO DESC"; break; // 회원 번호 내림차순으로 정렬
		case 2 : query = "MEMBER_NO"; break; // 회원 번호 오름차순으로 정렬
		case 3 : query = "MEMBER_EMAIL DESC"; break; // 이메일 내림차순으로 정렬
		case 4 : query = "MEMBER_EMAIL"; break; // 이메일 오름차순으로 정렬
		
		}
		
		return mapper.selectSort(query);
	}
	
	@Override
	public int restoration(int memberNo) {
		// TODO Auto-generated method stub
		return mapper.restoration(memberNo);
	}
	
	@Override
	public int changeAuthority(int memberNo) {
		// TODO Auto-generated method stub
		return mapper.changeAuthority(memberNo);
	}
	
	@Override
	public int initPw(int memberNo) {
		// TODO Auto-generated method stub
		
		// 암호화 된 1234
		String encPw = bcrypt.encode("1234"); 
		
		// 마이바티스 코드 -> 파라미터 1개만 가능 
		//
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("encPw", encPw);
		map.put("memberNo", memberNo);
		
		return mapper.initPw(map);
		
	}
	

}
