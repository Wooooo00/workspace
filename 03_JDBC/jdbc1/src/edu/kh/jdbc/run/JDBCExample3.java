package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample3 {
	
	public static void main(String[] args) {
		
		// 입력 받은 최소 급여보다 많이 받고 (이상)
		// 입력 받은 최고 급여보다는 적게 받는(이하)
		// 사원의 사번, 이름, 급여를 급여 내림차순 조회
		
		
		
		// [실행화면]
		// 최소 급여 : 1000000
		// 최대 급여 : 3000000 
		
		// 1. jdbc 객체 참조 변수 생성 ( Connection, Statement(java sql !! , ResultSet)
		// 2. DriverManager를 이용해 Conncection 객체 생성
		// 3. SQL 작성
		// 4. statement 
		// 5. Statement 객체를 이용해서 SQL 수행 후 결과 반환 받기
		// 6. SQL(SELECT) 결과가 담겨있는 ResultSet(rs)를 한 행씩 반복 접근하며 각 행의 컬럼값을 얻어와 출력
		// 7. 사용한 JDBC 객체 자원 반환(역순으로) 
		
		// 1. 
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@"; // 드라이버 종류
			 
			 String host = "115.90.212.20"; // DB 서버 컴퓨터 IP 주소
			 
			 String port = ":10000"; // DB서버 컴퓨터 내에서 DB프로그램 번호 
			 
			 String dbName = ":ORCL"; // DB 이름
			 
			 String userName ="a230724_lcw"; // 사용자 계정
			 
			 String pw = "1009"; // 비밀번호
			 
			 conn = DriverManager.getConnection(type + host + port + dbName, userName , pw); 
			
			 Scanner sc = new Scanner(System.in);
			 int input = sc.nextInt();
		
			 
			 
			
			 System.out.println();
			 String sql = "SELECT EMP_NO, EMP_NAME, SALARY"
					     + "FROM EMPLOYEE"
				         +  "WHERE SALARY BETWEEN 1000000 AND 3000000"
				         + "ORDER BY SALARY DESC";
			 System.out.println();
				
			  st = conn.createStatement();
			  rs = st.executeQuery(sql);
			  
			  while (rs.next()) {
				  String empNo = rs.getString("EMP_NO");
				  String empName = rs.getString("EMP_NAME");
				  int salary = rs.getInt("SALARY");
				  
				  System.out.printf("%s / %s / %d", empNo, empName,  salary);
				  
			  }
			 
			 
		} catch(Exception e) {
			e.printStackTrace();	
		
		} finally {
			
				try {				
					if(rs != null) rs.close();
					if(st != null) st.close();
					if(conn != null) conn.close();
				
		
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} 
						
		}

		    

//SELECT emp_no, emp_name, salary\r\n"
// 		+ "			 FROM EMPLOYEE\r\n"
// 		+ "			 WHERE SALARY BETWEEN 1000000 AND 3000000\r\n"
// 		+ "			 ORDER BY SALARY DESC ";
 


	
	
	
	
	}
	
	
	
}
	