package edu.kh.jdbc.model.service;

import java.sql.Connection;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.model.model.dao.MemberDAO;
import edu.kh.jdbc.model.model.dto.Member;

// Service : 비즈니스 로직
// - 요청에 따른 필요 데이터를 반환
// + DB 연결 코드인 DAO를 호출
// + Tracnsaction 제어 (commit, rollback)
// -> commit, rollback을 하려면 Connection이 필요하기 때문에
// Service에서 Connection을 생성


public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	
	/** @param member 
	 * 
	 */
	
	
	
	public int insertMember(Member member) {
	
		// 1. 커넥션 생성(JDBCTemplate 이용
		Connection conn = JDBCTemplate.getConnection();
		
		// 2. DAO 메서드 호출(커넥션, 매개변수 전달)
		// -> insert 성공한 행의 개수 반환
		
		int result = dao.insertMember(conn,member);
		
		if(result > 0) JDBCTemplate.commit(conn); // insert가 성공한 경우
		else           JDBCTemplate.rollback(conn); // insert가 실패한 경우
		
		// 4. 사용 완료된 커넥션 반환(close)
		JDBCTemplate.close(conn);
				
		
		// 5. SQL 수행 결과를 view 반환
		return result;
	}

	



}
