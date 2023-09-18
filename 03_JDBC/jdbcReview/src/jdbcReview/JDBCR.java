package jdbcReview;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class JDBCR {
	
	
	public static void main(String[] args) {
		
		// EMPLOYEE 테이블에서
		// 사번, 이름, 부서코드, 직급코드, 급여, 입사일 조회해서
		// 자바 프로그램 얻어와 콘솔에 출력하기
		
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@"; // 드라이버 종류
			String host = "115.90.212.20"; // DB 서버 컴퓨터 IP 주소
			String port = ":10000"; // DB 서버 컴퓨터 내에서 DB 프로그램 번호
			String dbName = ":ORCL"; // DB 이름
			String userName = "a230724_bdh"; // 사용자 계정
			String pw = "test1234"; // 비밀
			
			conn = DriverManager.getConnection(type + host + port + dbName + userName + pw);
			Scanner sc = new Scanner(System.in);
			System.out.print("최소 급여 : ");
			int min = sc.nextInt();
			
			int max = sc.nextInt();
			
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY, JOB_NAME\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE SALARY BETWEEN "+min+" AND "+max+"\r\n"
					+ "ORDER BY SALARY DESC"; 
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
			
			
			
	
		
		// JDBC -> 
		// 자바에서 DB에 접근할 수 있게 해주는 자바 제공 코드
		
		
	} catch(Exception e) {
		e.printStackTrace();
	}
		
	
	
	}
}
	
