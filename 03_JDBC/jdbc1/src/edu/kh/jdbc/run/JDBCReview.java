package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCReview {
	
	public static void main(String[] args) {
		
		// 부서명 입력 받아 해당 부서에서 근무하는 모든 사원의 사번, 이름, 부서명, 직급명을 직급코드 오름차순으로
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try { 
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@"; // 드라이버 종류
			 
			 String host = "115.90.212.20"; // DB 서버 컴퓨터 IP 주소
			 
			 String port = ":10000"; // DB서버 컴퓨터 내에서 DB프로그램 번호 
			 
			 String dbName = ":ORCL"; // DB 이름
			 
			 String userName ="a230724_lcw"; // 사용자 계정
			 
			 String pw = "1009"; // 비밀번호
			 
			 // DriverManager : Connection 만드는 객체
			 conn = DriverManager.getConnection(type + host +port + dbName, userName , pw);
			 // -> 어떤 타입의 어디에 있는 DB와 어떤 계정으로 연결할 건지에 대한 
			 // 연결 방법을 저장한 Connection 객체 생성
			 
			
		     System.out.println(conn);
			 
			 // 3. SQL 작성
			 // 단, 마지막 세미콜론은 제외해야 한다.
			 Scanner sc = new Scanner(System.in);
			 
			 int input = sc.nextInt();
			 
			 // 입력 받은 문자열이 저장된 변수를 sql 추가할 때 
			 // 양쪽에 홑따옴표(' ')를 반드시 작성해야 한다.
			 String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME"
					+ "FROM EMPLOYEE" 
					+ "JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)"
					+ "JOIN JOB USING (JOB_CODE)"
					+ "WHERE DEPT_TITLE = '"+input+"'"
					+ "ORDER BY JOB_CODE"; 
			 		
			 stmt = conn.createStatement();
			 // 연결된 DB와 대화(SQL 수행 / 결과 반환
			 
			 boolean flag = true; // true면 조회 결과 없음, false면 있음
			 
		
	     while(rs.next()) {
	    	flag = false; 
	    	 
			String empId = rs.getString("EMP_ID");
			String empName = rs.getString("EMP_NAME");
			String deptTitle = rs.getString("DEPT_TITLE");
			String jobName = rs.getString("JOB_NAME");
			
	    	System.out.printf("%s / %s /%s /%s ", empId, empName, deptTitle, jobName);
		}
			 
	     if(flag) {
	    	 
	    	 
	     }
			 
		} catch(Exception e) {
			
			e.printStackTrace();
			
	    } finally {
	    	
	    	if(rs != null) rs.close();
	    	if(stmt != null) stmt.close();
	    	if(conn != null) conn.close();
	    	
	    	
	    }

		
		
	}
	
	
	
}
