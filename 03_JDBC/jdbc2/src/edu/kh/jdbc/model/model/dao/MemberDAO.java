package edu.kh.jdbc.model.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.model.model.dto.Member;

public class MemberDAO {
	
	
	// 필드
	// JDBC 객체 참조 변수 선언
	
	private Statement stmt = null;
	
	private ResultSet rs = null;
	
	// PreparedStatement (준비된 Statement)
	// - 외수 변수 값을 SQL에 삽일할 준비가 되어 있는 Statement
	// -> 성능, 속도 면에서 우위를 가지고 있음
	
	// -> ?(place holder) : 변수를 위치시킬 자리 지정
	private PreparedStatement pstmt = null;
	
	
	
	public int insertMember(Connection conn, Member member) {
		
		// DAO 작성법
		// 1. 최종 결과를 저장할 변수 선언 또는 객체 생성
		int result = 0;
		
		// 2. SQL 작성
		
		// 1) Statement를 이용해서 수행할 SQL 작성법 -- 작성이 어렵다
		//    그래서 Statement의 자식인 preparedStatement 사용
		
//		String sql = "INSERT INTO MEMBER \r\n"
//				+ "VALUES(SEQ_MEMBER_NO.NEXTVAL, "
//				+ "'" + member.getMemberEmail()+" ', 
//				+ "', "
//				+ "'a1',\r\n"
//				+ "       '01012345678', "
//				+ "'서울시 용산구', "
//				+ "DEFAULT,"
//				+ " DEFAULT)"
//				+ ; 
		// 2) PreparedStatement용 SQL 작성
		String sql = "INSERT INTO MEMBER "
				+ "VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, DEFAULT, DEFAULT) ";
		
		
		

		try {
			// 3) preparedStatement 객체 생성
			// (Statement와 다르게 생성 시 SQL을 매개 변수로 사용함)
			// -> SQL을 생성할 때 전달하여 ?에 값 대입을 준비함
			pstmt = conn.prepareStatement(sql);
			
			// 4. ?(placeholder)에 알맞은 값 대입
			// ***** pstmt.set 자료형(순서, 값); 
			
			// ** pstmt.setString()으로 문자열을 SQL에 대입하면
			// 자동으로 양쪽에 ' ' 추가해준다 
			
			pstmt.setString(1,member.getMemberEmail());
			pstmt.setString(2,member.getMemberPw());
			pstmt.setString(3,member.getMemberNickname());
			pstmt.setString(4,member.getMemberTel());
			pstmt.setString(5,member.getMemberAddress());
			
			// 5. SQL 수행 후 결과 반환 받기
			result = pstmt.executeUpdate(); // 매개 변수에 SQL 추가 X 
			
			
			// 왜? 이미 pstmt 생성할 때 추가했기 때문에
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return result; 
	}


}
