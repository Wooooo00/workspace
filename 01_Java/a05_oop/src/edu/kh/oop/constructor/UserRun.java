package edu.kh.oop.constructor;

public class UserRun {
	public static void main(String[] args) {
		
		// 사용자 객체 생성
		User u1 = new User();
		              // -> 기본 생성자
					  // -> 기본 생성자를 작성하지 않아도 
					  // 컴파일러가 자동으로 추가해주기 때문에 오류 발생 X 
		
		// 오버로딩으로 만든 다양한 생성자를 이용해 객체 생성
		User u2 = new User("홍길동");
		
		User u3 = new User(24, "홍길");
		
		User u4 = new User("김미영", 27);
		
		User u5 = new User("서울시 용산구");
		
		
				
	
		System.out.println("종료");
		
	}

}
