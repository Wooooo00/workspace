package edu.kh.jdbc.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Board;
import edu.kh.jdbc.model.dto.Member;
import edu.kh.jdbc.model.service.ProjectService;

public class ProjectView {

	private Scanner sc = new Scanner(System.in);
	private ProjectService service = new ProjectService();

	// 로그인한 회원의 정보가 담긴 Member 객체를 참조할 변수 선언
	private Member loginMember = null;
	
	
	public void displayMenu() {
		int input = -1;

		do {
			try {
			    if(loginMember != null) { // 로그인 상태인 경우
			    	System.out.println("--------------");
			    	System.out.printf("(%s) \n", loginMember.getMemberEmail());
			    	System.out.println("--------------");
			    } 
				
				System.out.println("\n***** MEMBER/BOARD 테이블 사용 JDBC ***** \n");
				System.out.println("1. 회원 가입");
				System.out.println("2. 로그인");
				System.out.println("3. 회원 정보 수정"); // 닉네임, 전화번호 UPDATE
				System.out.println("4. 회원 탈퇴"); // MEMBER_DEL_FL = 'Y' UPDATE
				System.out.println("5.MEMBER 테이블 전체 조회");
				
				
	            // ------------------ 게시글 목록 조회(selectBoardList) ------------------
	            // 게시글 번호, 제목, 작성일, 조회수, 작성자번호, 작성자 닉네임
	            // 게시글 번호 내림차순으로 조회
	            // 단, 삭제되지 않은 글만 조회(BOARD_DEL_FL = 'N')
	            System.out.println("7. 게시글 목록 조회"); // selectBoardList()
	            
	            
	            // ------------------ 게시글 상세 조회(selectBoard) ------------------
	            // 게시글 번호를 입력 받아 일치하는 게시글의
	            // 제목, 내용, 작성일, 조회수, 작성자번호, 작성자 닉네임 조회
	            // 단, 삭제되지 않은 게시글만 조회 가능(BOARD_DEL_FL = 'N')
	            
	            // view 메서드 1개 - service 메서드 1개 -  dao 메서드 2개
	            // service에서 dao의 메서드를 연달아 호출
	            // 1) 게시글 상세조회(selectBoard(게시글번호)) 를 먼저 수행
	            // 2) 게시글 상세 조회 결과가 있을 경우 -> 조회수 증가(incrementReadCount(게시글 번호)) 수행
	            System.out.println("8. 게시글 상세조회"); 
	         
							
	            // ------------------ 게시글 삭제(deleteBoard) ------------------
	            // 1) 로그인 여부 확인
	            
	            // 2) 로그인 상태인 경우 게시글 번호를 입력 받아
	            // 해당 게시글 작성 회원 번호(BOARD.MEMBER_NO)와 
	            // 로그인한 회원의 회원 번호(MEMBER.MEMBER_NO)가 일치하는지 확인하는 service 메서드 호출
	            
	            // 로그인 여부를 확인 
	            // 로그인이 되었으면 진행 
	            // 아니라면 로그인을 하고 시작 
	            // BOARD.MEMBER_NO 와 회원 번호가 일치하는지 확인
	            
	            
	            
	            // 3) 일치할 경우
	            // 정말 삭제하시겠습니까?(Y/N)을 출력 
	            // -> Y 입력 시 BOARD_DEL_FL 컬럼 값을 'Y'로 수정하는 service 메서드 호출
	            System.out.println("9. 게시글 삭제");
	            
	            
	            // ------------------ 게시글 수정(updateBoard)  ------------------
	            // 1) 로그인 여부 확인
	            
	            // 2) 로그인 상태인 경우 게시글 번호를 입력 받아
	            // 해당 게시글 작성 회원 번호(BOARD.MEMBER_NO)와 
	            // 로그인한 회원의 회원 번호(MEMBER.MEMBER_NO)가 일치하는지 확인하는 service 메서드 호출
	            
	            // 3) 일치할 경우
	            // 수정할 제목, 내용을 입력 받아 해당 게시글의 제목, 내용을 수정
	            System.out.println("10. 게시글 수정");
	            
				
				
				
				System.out.println("0. 프로그램 종료");

				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행 문자 제거

				switch (input) {
				case 1: insertMember(); 
					break;
				case 2: login(); 
					break;
				case 3: updateMember(); 
					break;
				case 4: updateDelFl();
					break;
				case 5: selectAllMember();
					break;
				case 6 : insertBoard();
					break; 				
					
				case 7 : 
					break;
				case 8 : selectBoard();
					break;
				case 9 : deleteBoard();
					break;
					
				case 10 : updateBoard();
					break;
				case 0:
					System.out.println("\n--- 프로그램 종료 ---\n");
					break;
				default:
					System.out.println("\n*** 메뉴 번호만 입력해주세요 ***\n");
				}

			} catch (InputMismatchException e) {
				System.out.println("\n잘못된 입력\n");
				sc.nextLine();
			}
		} while (input != 0);
	}

	

	/**
	 * 회원 가입 화면
	 */
	private void insertMember() {
		System.out.println("\n***** 회원 가입 *****\n");

		System.out.print("이메일 : ");
		String email = sc.next();

		System.out.print("비밀번호 : ");
		String pw = sc.next();

		System.out.print("닉네임 : ");
		String nickname = sc.next();

		System.out.print("휴대폰 번호(- 제외) : ");
		String tel = sc.next();
		sc.nextLine(); // 입력 버퍼 개행문자 제거

		System.out.print("주소 : ");
		String address = sc.nextLine();

		// 입력 받은 값을 Member 객체에 저장하기
		Member member = new Member(email, pw, nickname, tel, address);

		// 서비스로 member를 전달한 후 수행 결과 반환 받기
		// -> DML(INSERT,UPDATE,DELETE) 결과는 성공한 행의 수(int)로 반환

		int result = service.insertMember(member); // 1 또는 0

		if (result > 0) {
			System.out.println("회원 가입 성공!!!");
		} else {
			System.out.println("회원 가입 실패......");
		}
	}
	
	private void login() {
		System.out.println("\n *** 로그인 *** \n");
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		// 로그인 서비스 호출 후 결과(Member) 반환 받기
		Member member = service.login(email, pw);
		
		// 로그인 결과에 따라 출력하기
		  if (member != null) { 
			System.out.println("\n 로그인 성공 \n");
			System.out.println(member);
			
			loginMember = member;
		} else {
			System.out.println("\n *** 로그인 실패 *** \n");
			
		}
	}
	
	
	// 멤버 테이블 전체 조회
	private void selectAllMember() {
		System.out.println("\n *** MEMBER 테이블 전체 조회 *** \n");
	
		System.out.print("내림차순 조회(1), 오름차순(아무 숫자) : ");
		int sort = sc.nextInt();
		
		List<Member> memberList = service.selectAllMember(sort);
		
		// 조회 결과가 없을 경우 (memberList 비어있을 경우, null이 아님) 
	//  if(memberList.isEmpty()) {
		if(memberList.size() == 0) {
			System.out.println("\n 조회 결과가 없습니다 \n");
			
		} else {
			// 향상된 for문으로 리스트에 모든 값 출력
			
			for(Member mem : memberList) {
				System.out.println(mem);
			}
		}
		
		
	}
	
	private void updateMember() {
		// 로그인 여부 확인
		if(loginMember == null) {
			System.out.println("\n ***** 로그인 후 이용해주세요 *****\n");
			return ;
		}
		// 로그인 되어 있을 경우
		
		System.out.print("수정할 닉네임 : ");
		String nickname = sc.next();
		System.out.print("수정할 전화번호(- 제외) : ");
		String tel = sc.next();
		
		// 회원 정보 수정 서비스 호출 후 결과 반환
		// 수정할 닉네임, 전화번호, 회원번호(PK 조건절에 이용)
		int result = service.updateMember(nickname, tel, loginMember.getMemberNo());
	    
		if(result > 0) System.out.println("수정 성공");
		else           System.out.println("수정 실패");
	}
	
	private void updateDelFl() {
		
		System.out.println("\n 회원 탈퇴 \n");
		
		// 로그인 여부 확인
		if(loginMember == null) {
			System.out.println("로그인 후 이용해주세요");
			return;			
		}
		
		System.out.print("비밀번호를 입력해주세요: ");
		String pw = sc.next();
		
		int result = service.updateMemberDelFl(loginMember.getMemberNo(), pw);
		
		if(result > 0) {
			System.out.println("탈퇴 되었습니다");
			loginMember = null;
		} else {
			System.out.println("비밀번호 다시 입력");
		}
		
		
		
		
	
		
		
			
		}
		
		
		// 로그인 상태인 경우
		// 1) 비밀번호 입력 받기
		
		// 2) 서비스 메서드 호출 후 결과 반환 받기
		// - 매개 변수 : 회원번호, 입력 받은 비밀번호
		// - 반환값 : SQL 수행 후 결과 행의 개수
		
		// 3) 성공일 경우 : "탈퇴 되었습니다", loginMember = null;
		//    실패일 경우 : "비밀번호가 일치하지 않습니다" 
		
	private void insertBoard() {
		System.out.println("\n*** 게시글 작성 ***\n ");
		
		// 로그인 여부 확인 
		if(loginMember == null) {
			System.out.println(" \n*** 로그인 후 이용해주세요 ***\n");
			return;
		}
		
		System.out.print("제목 입력 : ");
		String title = sc.nextLine();
		
		System.out.println("내용 입력(입력 종료 : !wq");
		String content = " "; 
		
		while(true) {  // 무한 루프 
			String temp = sc.nextLine();
			
			if(temp.equals("!wq")) { // 입력 종료 커맨드인 경우
				break;
				
			}
			
			content += temp + "\n"; // 입력 받은 한 줄을 content에 누적
		}
		
		// BOARD 테이블에 삽입하는 서비스 호출 후 결과를 반환 받기
		int result = service.insertBoard(title, content, loginMember.getMemberNo());
					 // 제목, 내용, 작성자 회원 번호	
		if(result > 0) { // 삽입 성공했을 때
			System.out.println("***게시글이 등록 되었습니다***");
			
			
		} else {
			System.out.println("***게시글 등록 실패***");
		}
		
 	}

	private void selectBoard() {
		
		System.out.println("\n *** 게시글 상세 조회 *** \n");
		
		System.out.print("게시글 번호 입력 : " );
		int boardNo = sc.nextInt();
		
		Board board = service.selectBoard(boardNo);
		
		// 서비스 메서드 호출 후 결과 반환 받기

		
		// 조회 결과 존재하지 않을 경우
		
		if(board == null) {
			System.out.println("\n *** 해당 게시글이 존재하지 않습니다 *** \n");
			return;
		}
		
		System.out.printf("[%d] %s \n", 
						board.getBoardNo(), board.getBoardTitle());
		
		System.out.println("작성일 : " + board.getBoardCreateDate());
		System.out.println("조회수 : " + board.getReadCount());
		System.out.printf("작성자 : %s " + board.getMemberNickname(), board.getMemberNo());
	}
		
	
	
	
	public void deleteBoard() {
		
		if(loginMember == null) {
			System.out.println("\n ***** 로그인 후 이용해주세요 *****\n");
			return ;
		}
		
		
		// 로그인 되어 있을 경우
		
		System.out.print("삭제할 게시글 번호를 입력해주세요 : " );
		int boardNo = sc.nextInt();
		
		if(boardNo == 0); {
			System.out.println("***해당 번호의 게시글이 존재하지 않습니다***");
			return;
	
		} else {
			System.out.println();
			
		}
		
		
		// 회원 정보 수정 서비스 호출 후 결과 반환
		// 수정할 닉네임, 전화번호, 회원번호(PK 조건절에 이용)
		
	}
	
	private void updateBoard() {
	 int result = null;
		if(loginMember == null) {
			System.out.println("\n ***** 로그인 후 이용해주세요 *****\n");
			return ;
		}
		
		System.out.print(" 수정할 게시글 번호를 입력해주세요 : " );
		int boardNo = sc.nextInt(); 
		
		
		
		
		
	}
	
	
	
	
	
	}
		
	
	

