package edu.kh.io.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.io.model.dto.Member;
import edu.kh.io.service.MemberService;

public class MemberView {

	private Scanner sc = new Scanner(System.in);
	
	// MemberService 객체 생성
	
	private MemberService service = new MemberService();
	
	// 메뉴 출력 뷰
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			
			try {
				System.out.println();
				System.out.println("\n ###회원 관리 프로그램### \n");
				System.out.println("1. 회원가입");
				System.out.println("2. 회원 목록 조회");
				System.out.println("3. 아이디/비밀번호 일치하는 회원 조회");
				System.out.println("0. 종료");
				
				System.out.print("메뉴 선택 : ");
				input = sc.nextInt();
				
				switch(input) {
				
				case 1 : signUp(); break;
				
				case 2 : selectAll(); break;
								
				case 3 : selectOne(); break;
				
				case 0 :  System.out.println("[프로그램이 종료 됩니다.]");
				
				default : System.out.println("[메뉴의 번호만 입력해주세요.]");
				
				}
				
				
				
				
			} catch (InputMismatchException e) {
				System.out.println("[잘못된 입력입니다.]");
				input = -1; // 처음 반복에서 예외 발생 시 while문 종료 방지
				sc.nextLine(); // 입력 버퍼에 잘못 입력된 문자열 제거
				
			}
			
		} while(input != 0); 
			
		
		
	}
	
	private void signUp() {
		
		System.out.print("가입하고자하는 아이디를 입력하세요 : ");
		System.out.println();
		
		System.out.print("비밀번호를 입력하세요 : ");
		System.out.println();
		
		System.out.print("이름을 입력하세요 : ");
		System.out.println();
		
		System.out.print("포인트 : ");
		System.out.println();
		
		String id = sc.next();
		
		String pw = sc.next();
		
		String name = sc.next();
		
		int point = sc.nextInt();
		
		// 입력 받은 값을 서비스에 전달하고 회원 가입(memberList에 추가) 
		// 성공하면 true 실패(아이디가 중복)이면 false 
		
		boolean result = service.signUp(id, pw, name, point);
		
		if(result) {
			System.out.println(id + "회원가입이 완료 되었습니다.");
			
		} else {
			System.out.println("이미 사용 중인 아이디입니다.");
		}
	}
	
	// 회원 목록 조회하는 뷰 
	private void selectAll() {
		System.out.println("회원 목록 조회");
		
		// Service로부터 회원 목록을 반환 받아서 모두 출력
		List<Member> memberList = service.selectAll();
		
		// 회원 목록이 비어있을 경우 == 회원이 없는 경우
		// ==memberList.txt 파일이 없어서 읽어온 회원 목록이 없는 경우
		
		if(memberList.isEmpty()) {
			System.out.println("존재하는 회원이 없습니다");
			return;
		}
		
		// 회원이 있을 경우 향상된 for문으로 모두 출력 
		// for(참조형 : 목록)
		for(Member mem : memberList)   System.out.println(mem);
	}
	
	/** 아이디/비밀번호 일치 회원 조회 view
	 * 	
	 * 
	 */
	private void selectOne() {
	System.out.println("ID : ");
	String id = sc.next();
	System.out.println("PW : ");
	String pw = sc.next();
	
	// 입력 받은 값을 서비스로 전달하여
	// 일치하는 회원(Member) 반환, 없으면 null 반환
	
	Member mem = service.selectOne(id,pw);
	
	if(mem == null) {
		System.out.println("<<일치하는 회원이 없습니다>>");
		
	} else {
		System.out.println("ID : " + mem.getId());
		System.out.println("PW : " + mem.getPw());
		System.out.println("이름 : " + mem.getName());
		System.out.println("포인트 : " + mem.getPoint());
	}
	
	}
	
}
