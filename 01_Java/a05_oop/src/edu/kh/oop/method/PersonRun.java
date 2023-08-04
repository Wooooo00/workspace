package edu.kh.oop.method;

public class PersonRun {
	public static void main(String[] args) {
		
		// 사람 객체 생성
			Person p1 = new Person();
		
		// p1이 참조하는 객체의 name 필드값을 세팅
			p1.setName("김개똥");
			
			String result = p1.getName(); // "김개똥" 
							// 반환형 String 변수에 저장 가능
			
			System.out.println("result: " + result);
			
			System.out.println("종료");
	}
	

}
