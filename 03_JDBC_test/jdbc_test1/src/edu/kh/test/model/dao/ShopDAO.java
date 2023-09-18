package edu.kh.test.model.dao;

import static edu.kh.test.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.kh.test.model.dto.ShopMember;

public class ShopDAO {

	private Connection conn = null;
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ShopMember selectMember(Connection conn, String Member) {
		ShopMember sm = null;
		
		try { 
			String sql = "SELECT MEMBER_ID \r\n"
					+ "FROM SHOP_MEMBER\r\n"
					+ "WHERE MEMBER_ID =  '?'";
					pstmt = conn.prepareStatement(sql);
		
		  if(rs.next()) {
			  String id = rs.getString("MEMBER_ID");
			  String pw = rs.getString("MEMBER_PW");	  
			  String phone = rs.getString("PHONE");	  
			  String gender = rs.getString("");	  
		  
		  rs = pstmt.executeQuery();
		  
		   sm  = new ShopMember(id,pw,phone,gender);
		   
		   close(rs);
		    
		  }
		  
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return sm;
		
		
	}
	

}



