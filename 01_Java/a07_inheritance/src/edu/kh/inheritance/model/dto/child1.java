package edu.kh.inheritance.model.dto;


// 상속 키워드 : extends 
// public class 자식 클래스 extends 부모 클래스 {}

public class child1 extends Parent {
	
	private String car;
	
	public Child1() {
		super();
	System.out.println("Child1() 매개변수 생성자");
}
	public Child1(String car) {	
		super();
	this.car = car;
	System.out.println();
}
	
	public String getCar() {
		return car;
	}
	
	public void setCar(String car) {
		this.car = car;		
	}
	
	// @ annotation 
	// 컴파일러가 보는 주석으로
	// 컴파일러에게 annotation에 작성된 내용을 보고 
	// 코드가 정상 작성 되었는지, 해당 코드가 실행 되기 전에 다른 코드를
	// 실행한다던지 
	// 코드가 해석되는 순서를 작성한다던지 .. 등이 가능
	
	@OVerride // 이 메서드가 부모 것을 재정의 한 것이므로 
				// 제대로 작성 되었는지 검사 해달라는 요청
	
// 
	
	
	public String toString() {
	// 상속 받은 Parent의 메서드를 	
		getMoney();
		getLastName();
		
		return car;
	}
	// new Child1 자식 객체가 생성될 때 생성자 첫 번째 줄에 작성된 
	//super() 생성자에 의해서 부모 객체가 자식 객체보다 항상 먼저 생성
	
	// 자식이 부모로부터 상속 받은 멤버(필드, 메서드) 사용
	
	// 아무리 inheritance여도 private는 직접 접근이 불가하다
	// 대신 간접 접근 방법 getter/setter 이용 가능
	
	//c1.money = 10;
	
	// 자식의 toString() 호출
	
	System.out.println(c1.toString() );

	
	// 오버라이딩
	// 위로 올라타다
	// 코드를 덮어 씌움
	// 부모로부터 상속 받은 메서드를 
	//자식이 원하는 형태로 재정의 하는 것.
	
	// 오버라이딩 특징
	// 부모의 메서드와 반환형, 메서드명, 매개변수까지 똑같음
	
	
	// 오버라이딩 연습
	// 부모로부터 상속 받은 getMoney()를 재정의
	@Override
	
	public int getMoney() {
		System.out.println("오버라이딩한 getMoney()");
		
		return (int)(super.getMoney)
		
	}
	
	// 
	
	
	
}
