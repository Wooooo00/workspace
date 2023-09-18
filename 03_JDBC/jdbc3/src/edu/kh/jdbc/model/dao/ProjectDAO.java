package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Board;
import edu.kh.jdbc.model.dto.Member; 

public class ProjectDAO {
	
	// JDBC 객체 참조 변수 선언
	
	// Connection : DB 연결 정보를 담고 있는 객체

	// Statement : Connection을 통해서 생성
	//           : SQL 수행 후 결과를 반환 받는 객체

	// PreparedStatement :  Connection을 통해서 생성
	//					 : 	SQL 중간에 삽입될 변수 자리를 ?(placeholder)로 지정해 
	// SQL을 변수 값에 따라서 쉽게 변화시킬 수 있는 Statement 자식 객체
	
	// ResultSet : SELECT 구문 수행 결과를 저장할 객체
	// 1행씩 접근하면서 컬럼 값을 얻어올 수 있음

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	

	public int insertMember(Connection conn, Member member) {
    // 
		// 1. 결과 저장용 변수 선언/생성
		
		int result = 0; 
		
		// 2. SQL 작성
		
		String sql = " INSERT INTO MEMBER "
				+ "VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, DEFAULT, DEFAULT)";
		
		try {
			// 3. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 4. ?(placeholder)에 알맞은 값 대입
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNickname());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberAddress());
			
			// 5. SQL(INSERT) 수행 후 결과(성공한 행의 개수) 반환 받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 사용한 JDBC 객체 자원 반환(close)
			close(pstmt);
		}
		
		// 7. SQL 수행 결과 반환
		return result;
	}

	public Member login(Connection conn, String email, String pw) {
		
		// 1. 결과 저장용 변수 선언
		Member member = null; 
		
		// 2. SQL 작성
		String sql = "SELECT MEMBER_NO, MEMBER_NICKNAME, MEMBER_TEL, MEMBER_ADDRESS,\r\n"
				+ "	   TO_CHAR(ENROLL_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI:SS ') ENROLL_DATE\r\n"
				+ "FROM MEMBER\r\n"
				+ "WHERE MEMBER_EMAIL = ?\r\n"
				+ "AND MEMBER_PW = ?\r\n"
				+ "AND MEMBER_DEL_FL = 'N'";
		
		try {
			// 3. prepareStatement 생성
			pstmt = conn.prepareStatement(sql);
			
			// 4. ?에 값 대입
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			
			// 5. SQL(SELECT) 수행 후 결과(RESULT SET) 반환 받기
			// SELECT -> executeQuery
			// DML -> executeUpdate
			
			rs = pstmt.executeQuery();
			
			// 6. ResultSet에 조회된 다음 행이 있는지 확인
			// 7. 아이디 비밀번호가 일치하는 경우는 1행만 존재한다
			
			// while(조건식) 대신 if(조건식) 사용 가능
			
			while(rs.next()) { // 결과가 있을 때 무조건 1행이면 if 사용을 권장
				
				// 7. 조회 결과가 있을 경우 컬럼 값을 모두 얻어오기
				int memberNo = rs.getInt("MEMBER_NO");
				
				String memberNickname = rs.getString("MEMBER_NICKNAME");
				String memberTel = rs.getString("MEMBER_TEl");
				String memberAddress = rs.getString("MEMBER_ADDRESS");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				// + 매개 변수 email
				
				// 8. Member 객체를 생성하여 얻어온 값을 모두 세팅
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
			// 9. 사용한 JDBC 객체 반환(역순)
			
			// pstmt, rs
			close(rs);
			close(pstmt);
			
		}
			
		// member == null -> 로그인 실패
		// member != null -> 로그인 성공
		return member;
	}

	public List<Member> selectAllMember(Connection conn, int sort) {
		// 1. 결과 저장용 객체를 생성
		List<Member> memberList = new ArrayList<Member>();
		
		// 2. SQL 작성
		String sql = "SELECT * FROM MEMBER ORDER BY MEMBER_NO";
		
		// sort 값에 따라서 SQL 변경하기
		if(sort == 1) sql += " DESC";
		
		try {
			
//		    3.   -- Statement 버전 --
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
			
			// 3.-- prepareStatement 버전 --			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		//	4. 조회 결과 1행씩 접근(여러 행이면 while, 한 행이면 if) 
			while(rs.next()) { 
			//	int memberNo = rs.getInt("MEMBER_NO") // 컬럼명
				int memberNo = rs.getInt(1); // 컬럼 순서
				String memberEmail = rs.getString(2);
				String memberPw = rs.getString(3);
				String memberNickname = rs.getString(4);
				String memberTel = rs.getString(5);
				String memberAddress = rs.getString(6);
				
				// java.sql.Date 
				Date enrollDate = rs.getDate(7);
				// 
				String memberDelFl = rs.getString(8);
				
				// 5. Member 객체를 생성하여 컬럼값 세팅 후 리스트에 추가
				Member member = new Member(memberNo, memberEmail, memberPw, memberNickname,
						memberTel, memberAddress, enrollDate.toString(), memberDelFl);
				
				memberList.add(member);
			} // while 끝나는 부분
			
			} catch(Exception e) {
				
			} finally {
				// 6. 사용한 JDBC 객체 반환
				close(rs);
				close(pstmt);
			}
		
		return memberList;
	}
	
			// 7. 결과 반환
	
	


	public int updateMember(Connection conn, String nickname, String tel, int memberNo) {
		// TODO Auto-generated method stub
		int result = 0;
		
		String sql = "UPDATE MEMBER SET \r\n"
				+ "MEMBER_NICKNAME = ?, \r\n"
				+ "MEMBER_TEL = ?\r\n"
				+ "WHERE MEMBER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nickname);
			pstmt.setString(1, nickname);
			pstmt.setString(1, nickname);
			pstmt.setString(1, nickname);
			pstmt.setString(1, nickname);
				
			result = pstmt.executeUpdate();
			
			}     catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				close(pstmt);
			}
			return result;
			
	}
	

	public int updateMember(Connection conn, int memberNo, String pw) {
		int result = 0;
		
		
		String sql = "UPDATE MEMBER SET \r\n"
				+ "MEMBER_DEL_FL = 'Y'\r\n"
				+ "WHERE MEMBER_NO = ?\r\n"
				+ "AND MEMBER_PW = ?";
				

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, pw);
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
		
	

	public int insertBoard(Connection conn, String title, String content, int memberNo) {
		
		int result = 0;
		String sql = "INSERT INTO BOARD \r\n"
				+ "VALUES (SEQ_BOARD_NO.NEXTVAL, ?, ?, DEFAULT, DEFAULT, DEFAULT, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,title);
			pstmt.setString(2,title);
			pstmt.setString(3,title);
		
		result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
			
			
			
		
			
		}
		return result;
	}

	public Board selectBoard(Connection conn, int boardNo) {
		// TODO Auto-generated method stub
		Board board = null;
		
		String sql = " SELECT BOARD_TITLE, BOARD_CONTENT, \r\n"
				+ " TO_CHAR(ENROLL_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI:SS ') B_CREATE_DATE, \r\n"
				+ " READ_COUNT, MEMBER_NO, MEMBER_NICKNAME \r\n"
				+ "FROM BOARD \r\n"
				+ "JOIN MEMBER USING(MEMBER_NO)\r\n"
				+ "WHERE BOARD_DEL_FL = 'N'\r\n"
				+ "AND BOARD_NO = '?' ";
		
		try {
			// pstmt 생성
			pstmt = conn.prepareStatement(sql);
			
			// ?에 알맞은 값 세팅
			pstmt.setInt(1, boardNo);
			
			// sql (select) 수행 후 결과 (ResultSet) 반환 받기
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 조회 결과가 있을 경우
				board = new Board();
				
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				
				board.setBoardCreateDate(rs.getString("B_CREATE_DATE"));
				
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setMemberNo(rs.getInt("MEMBER_NO"));
				board.setMemberNickname(rs.getString("MEMBER_NICKNAME"));
			
				
				
				
				
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return board;
		
	}

	// 조회수 증가 시키기 
	public int incrementReadCount(Connection conn, int boardNo) {
		int result = 0;
		
		String sql = "UPDATE BOARD SET \r\n"
				+ "READ_COUNT = READ_COUNT + 1\r\n"
				+ "WHERE BOARD_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
		
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	
	public int deleteBoard(Connection conn, int boardNo) {
		int result = 0;

		String sql = "UPDATE BOARD SET \r\n"
				+ "BOARD_DEL_FL = 'Y'\r\n"
				+ "WHERE BOARD_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	
	}
		
	
	

	
 // DAO 클래스 끝
