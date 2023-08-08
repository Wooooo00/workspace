package edu.kh.poly.model.dto;

import edu.kh.poly.model.dto.Animal;
public class AbstractRun {
	
	public static void main(String[] args) {
		
		// 1. 추상 클래스는 정말로 객체를 못 만들까?
		// Animal a = new Animal(); <- 에러
		
		// 2. 상속 받은 클래스는 객체 생성 가능할까?
		Person p = new Person("포유류", "잡식", "홍길동", 25);
		
		Fish f = new Fish("어류", "육식", 4);
		
		// 3. 추상 클래스는 부모 타입 참조 변수는 가능
		// 다형성(업캐스팅)
		Animal a1 = p;
		Animal a2 = f;
		
		// 4. 추상 클래스 + 다형성 업캐스팅 + 동적 바인딩
		System.out.println(a1.toString());
		a1.breath();
		
		System.out.println(a2.toString());
		a2.breath();
	}
	
		// 참조 변수를 print 구문에 작성 시 
		// 컴파일러가 .toString()을 붙여줌

}
