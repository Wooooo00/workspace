package edu.kh.project.myPage.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.controller.MyPageService;
import edu.kh.project.myPage.model.dao.MyPageDAO;

// Service : 비즈니스 로직 처리(데이터 가공, DB 연결, 트랜잭션 제어)


@Service //  
public class MyPageServiceImpl implements MyPageService {
	
	
	
	
	@Autowired // MyPageDAO 또는 상속 관계 , bean DI(의존성 주입)
	private MyPageDAO dao;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Transactional(rollbackFor = Exception.class) // 정상 수행 시 commit, 예외 발생 시 rollback
	@Override
	public int info(Member updateMember, String[] memberAddress) {
		// TODO Auto-generated method stub
		
		// 1) memberAddress 가공 처리
		if(updateMember.getMemberAddress().equals(",,")) {
			updateMember.setMemberAddress(null);
		} else {
			
			String addr = String.join("^^^", memberAddress);
			updateMember.setMemberAddress(addr);
		}
		
		return dao.info(updateMember);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
		// TODO Auto-generated method stub
		
		// 1.로그인한 회원의 암호화된 비밀번호 조회
		
		String encPw = dao.selectMemberPw(memberNo); 
		
		// 2.현재 비밀번호와 조회한 비밀번호가 같은지 확인
		//	같으면 -> 비밀번호 변경
		//  다르면 -> return 0
		
		// Bcrypt에서 제공하는 matches() 이용
		if(!bcrypt.matches(currentPw, encPw)) {
			
			return 0;
		}
		
		// 3.비밀번호 변경 DAO 메서드 호출 전
		// newPw, memberNo를 하나의 객체에 저장
		// 왜? 마이바티스 코드는 파라미터를 하나만 전달할 수 있어서
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("newPw", bcrypt.encode(newPw));
		map.put("memberNo", memberNo);
		
		// 4. DAO 메서드 호출 후 반환된 결과를
		// Controller로 반환 + @Transcactional
		return dao.changePw(map);
		
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int secession(String memberPw, int memberNo) {
		
		String encPw = dao.selectMemberPw(memberNo);
		
		if(!bcrypt.matches(memberPw, encPw)) {
			
			return 0;
		}
		
		
		
			
		
		
		// 입력 받은 비밀번호가 
		// DB에 저장된 로그인한 회원의 비밀번호가 같다면
		// 회원 탈퇴 수행 후 반환
		
		// TODO Auto-generated method stub
		return dao.secession(memberNo);
	}
	
}
