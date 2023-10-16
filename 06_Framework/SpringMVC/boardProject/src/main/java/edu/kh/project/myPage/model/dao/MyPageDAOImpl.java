package edu.kh.project.myPage.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

// DAO(Database Access Object) : DB 접근 객체(SQL 수행 후 결과 반환)
// Repository : 저장소(DB, 파일, ftp server)

@Repository // 저장소 연결 역할

public class MyPageDAOImpl implements MyPageDAO {
	
	// JDBC
	
	// Mybatis
	// - JDBC(JAVA와 DB 연결을 위한 Java API) 프레임 워크
	// Mybatis를 이용한 DB 연결 + DBCP 트랜잭션 자동 제어
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int info(Member updateMember) {
		// TODO Auto-generated method stub
		// 마이바티스 객체를 이용해서 update 수행 
		
		// sqlSession.update("namespace값.id값", 파라미터)
		return sqlSession.update("myPageMapper.info", updateMember) ;
	}
	
	@Override
	public String selectMemberPw(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("myPageMapper.selectMemberPw", memberNo) ;
	}
	
	@Override
	public int changePw(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update("myPageMapper.changePw", map);
	}
	
	public int secession(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSession.update("mypageMapper.secession", memberNo );
	}
}
