package edu.kh.project.myPage.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.mapper.MyPageMapper;

@Transactional
@Service
public class MyPageServiceImpl implements MyPageService {
	@Autowired
	private MyPageMapper mapper;
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	public int info(Member updateMember, String[] memberAddress) {
		// TODO Auto-generated method stub
		
		// 주소 가공
		if(updateMember.getMemberAddress().equals(",,")) {
			updateMember.setMemberAddress(null);
			
		} else {
			String address = String.join("^^^", memberAddress);
			updateMember.setMemberAddress(address);
			
		}
		
		return mapper.info(updateMember);
	}
	
	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
		
		String encPw = mapper.selectMemberPw(memberNo);
		
		if(!bcrypt.matches(currentPw, encPw)) {
			// 현재 비밀번호와 조회한 비밀번호가 다른 경우
			return 0;
		
		} else { 
			
			// 같으면 새 비밀번호 변경
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("newPw", bcrypt.encode(newPw));
	    map.put("memberNo", memberNo);
	    
	    return mapper.changePw(map);
		}
		
	}
		
	
	@Override
	public int secession(String memberPw, int memberNo) {
		// TODO Auto-generated method stub
		
		String encPw = mapper.selectMemberPw(memberNo);
		
		if(!bcrypt.matches(memberPw, encPw)) {
			return 0;
		} return mapper.secession(memberNo);
		
	}
		
			// 현재 비밀번호와 조회한 비밀번호가 다른 경우
			
		
			
			
	}
	
	
			

			
	

