package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample2 {
	
	public static void main(String[] args) {
		
		// 입력 받은 급여보다 많이 받는 사원의 
		// 사번 이름, 급여, 직급명을 내림차순으로 조회하기
		
		// 1. JDBC 객체 참조 변수 선언
		Connection conn = null; 
		Statement stmt = null; // java.sql을 사용해야 함!!!
		ResultSet rs = null;
		
		// 2. DriverManager를 이용해 Conncection 객체 생성
		
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
						 
					String sql =  "SELECT EMP_NO, EMP_NAME, SALARY, JOB_NAME"
							+ "FROM EMPLOYEE"
							+ "JOIN JOB USING (JOB_CODE)"
							+ "WHERE SALARY >= "+input+" "
							+ "ORDER BY SALARY DESC" ;
				
					// 4. Statement 객체 생성						
					stmt = conn.createStatement();
					
					
				    // 5. Statement 객체를 이용해서 SQL 수행 후 결과 반환 받기				 
					rs = stmt.executeQuery(sql);				 
									 
					// 6. SQL(SELECT) 결과가 담겨있는 ResultSet(rs)를 한 행씩 반복 접근하며 각 행의 컬럼값을 얻어와 출력
					
					while(rs.next()) {
						
						String empId = rs.getString("EMP_ID");
						String empName = rs.getString("EMP_NAME");
						int salary = rs.getInt("SALARY");
						String jobName= rs.getString("JOB_NAME");
						
						System.out.printf("%s/ %s/ %d/ %s/ \n", empId, empName, salary, jobName);
					} // while문 종료					
					
					} catch(Exception e) {
						
						e.printStackTrace();
					}
					      // Exception : 모든 예외의 최상위 부모
						  // -> 다형성(업캐스팅)을 이용해서 모든 자식 예외를 잡아서 처리
		 			
				//	7. JDBC 객체 자원 반환 (역순으로)
		
					finally {
						
						try {
							if(rs != null) rs.close();
							if(stmt != null) stmt.close();
							if(conn != null) conn.close();
							
						} catch (Exception e) {
							e.printStackTrace();			
						}						
					}
					
				}
			
			}
