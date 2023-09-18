package edu.kh.jdbc.model.service;

import edu.kh.jdbc.model.dao.ProjectDAO;
import edu.kh.jdbc.model.dto.Board;
import edu.kh.jdbc.model.dto.Member;

// static 필드/메서드 호출 시 클래스명(JDBCTemplate) 생략
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List; 

public class ProjectService {
	
	private ProjectDAO dao = new ProjectDAO();
	private Statement stmt;
	private ResultSet rs;

	public int insertMember(Member member) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		
		// 2. DAO 메서드 호출(Connection, 매개 변수 전달)   DML 결과 -> 행의 개수(int)로 반환
		int result = dao.insertMember(conn, member);
		
		// 3. 트랜잭션 제어
		if(result > 0) commit(conn);
		else 		   rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
		// 5. 결과 view로 반환
		return result; 
	}

	// 로그인
	
	
		// 1. 커넥션 생성
		
		
		// 2. DAO 메서드 호출
	
		
		// SELECT는 트랜잭션 제어 처리가 필요 없음 -> 건너 뛴다.
		// 3. 커넥션 반환하기
	
		// 4. view로 결과 반환

	public Member login(String email, String pw) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출
		Member member = dao.login(conn, email, pw);
		
		
		close(conn);
		
		
		return member;
	}
	
	public Member login2(Connection conn, String email, String pw) {
		
		Member member = null;
		
		
		String sql = " SELECT MEMBER_NO, MEMBER_NICKNAME, MEMBER_TEL, MEMBER_ADDRESS,\r\n"
				+ "	   TO_CHAR(ENROLL_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI:SS ') ENROLL_DATE\r\n"
				+ "FROM MEMBER\r\n"
				+ "WHERE MEMBER_EMAIL = '"+email+"'\r\n"
				+ "AND MEMBER_PW = '"+pw+"'\r\n"
				+ "AND MEMBER_DEL_FL = 'N' ";
		
		try {
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			// Statement가 SQL을 수행하려고 할 때 SQL을 전달해줌
			
				while(rs.next()) { // 결과가 있을 때 무조건 1행이면 if 사용을 권장
				
				// 7. 조회 결과가 있을 경우 컬럼 값을 모두 얻어오기
				int memberNo = rs.getInt("MEMBER_NO");
				
				String memberNickname = rs.getString("MEMBER_NICKNAME");
				String memberTel = rs.getString("MEMBER_TEl");
				String memberAddress = rs.getString("MEMBER_ADDRESS");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				// + 매개 변수 email
				
				
				member = new Member(); // 결과 저장용 변수가 Member 객체를 참조
				// == null 아님
				
				member.setMemberEmail(email);
				member.setMemberNo(memberNo);
				member.setMemberNickname(memberNickname);
				member.setMemberTel(memberTel);
				member.setMemberAddress(memberAddress);
				member.setEnrollDate(enrollDate);
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally { 
			
			// 8. 사용한 JDBC 객체 반환
			close(rs);
			close(stmt);
			
		}
		
		
		
		
		return member;
		
	}
	
	public List<Member> selectAllMember(int sort) {
		
		Connection conn = getConnection();
		// DAO 메서드 호출 후 결과 반환 받기
		List<Member> memberList = dao.selectAllMember(conn, sort);
	
		close(conn); // 커넥션 반환  
	
		return memberList; // 결과 반환
	}


	


	public int updateMember(String nickname, String tel, int memberNo) {
		
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, nickname, tel, memberNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		return result;
	}
	

	public int updateMemberDelFl(int memberNo, String pw) {
         Connection conn = getConnection();
		
		int result = dao.updateMember(conn,memberNo,pw);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		return result;
	}

	public int insertBoard(String title, String content, int memberNo) {
		Connection conn = getConnection();
		
		int result = dao.insertBoard(conn,title,content,memberNo);
		if(result > 0) commit(conn);
		else rollback(conn);
		return 0;
	}

	public Board selectBoard(int boardNo) {
		
		Connection conn = getConnection();
		
	// 
		Board board = dao.selectBoard(conn, boardNo);
		
		// 2) 게시글 상세 조회 결과가 있을 경우
		// -> 
		if(board != null) {
			
			int result = dao.incrementReadCount(conn, boardNo);
			
			if(result > 0) { 
				commit(conn);
				
				// DB와 데이터 동기화 
				// DB에서만 조회수가 1 증가하기 때문에 
				// 조회해둔 board에도 조회수 1을 증가시킨다
				
				board.setReadCount(board.getReadCount() + 1);
			}
			else rollback(conn);
			
			
		}
		
		close(conn);
		
		
		return board;
	}
	
	public Board deleteBoard(int MemberNo) {
		Connection conn = getConnection();
		
		int result = dao.selectBoard(conn, boardNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return null;
		
	}
	
	
	}

