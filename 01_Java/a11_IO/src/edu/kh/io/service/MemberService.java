package edu.kh.io.service;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.kh.io.model.dto.Member;


/**
 * 
 */
/**
 * 
 */
public class MemberService {
	
	private List<Member> memberList = null;
	
	// 기본 생성자 
	public MemberService() {
		
		// 외부 파일에 작성된 객체(List<Member>)를 읽어와서
		// memberList에 대입하는 코드 작성
		
		// FileInputStream, ObjectInputStream 사용
		ObjectInputStream ois = null;
		
		try {
			// 파일이 있으면 읽어와 저장된 객체(List<Member>)를 memberlist에 저장
			ois = new ObjectInputStream( new FileInputStream("object/memberList.txt"));
		
			memberList = (List<Member>)ois.readObject(); // object 
			             //  (다운 캐스팅)      object
 			
		} catch (FileNotFoundException e) {
			System.out.println("[memberList.txt 파일이 존재하지 않습니다]");
			
			memberList = new ArrayList<Member>(); // 비어있는 리스트를 memberList에 대입한다.
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} finally {
			try {
				if(ois != null) ois.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
	}

	
	
	// 회원 목록 반환 service 
	public List<Member> selectAll() {		
		return memberList;
	}


	
	
	/** 회원가입 서비스
	 * @param 
	 * @param pw
	 * @param name
	 * @param point
	 * @return 성공 true 아이디가 중복이면 false 
	 */
	public boolean signUp(String id, String pw, String name, int point) {
		
		// 아이디 중복 검사 먼저 진행
		for(Member mem : memberList) {
			if(mem.getId().equals(id)) { // String 기존에 있는 값().equals(입력한 값)으로 비교
				return false;
			}
		}
		// 1. 전달 받은 값을 이용해 Member 객체 생성 후 memberList에 추가
		memberList.add(new Member(id, pw, name, point));
		
		// 2. 회원이 추가된 memberList를 
		// memberList.txt 파일로 출력
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("object/memberList.txt"));
			
			oos.writeObject(memberList);	
			
		} catch (IOException e) {
			
			e.printStackTrace();
		
		} finally {
			
			try {
				if(oos != null) oos.close();
		
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
			return true;
		
	}


	
	/** 아이디/비밀번호 일치 회원 반환 서비스
	 * @param id
	 * @param pw
	 * @return 일치하면 멤버 객체 주소, 없으면 null
	 */
	public Member selectOne(String id, String pw) {
		
		for(Member mem : memberList) {
			
			if(mem.getId().equals(id) && mem.getPw().equals(pw)) {
				System.out.println("입력하신 아이디와 ID,PW 일치합니다." );
				return mem;
			} 
			else {
				return null;
			}
				
		}
			
		return null; 
			
	}
			
//	if(mem.getPw().equals(pw)) {
//		System.out.println("입력하신 비밀번호가 일치합니다.");			
//		return mem;
//
//	}
		
	

}
