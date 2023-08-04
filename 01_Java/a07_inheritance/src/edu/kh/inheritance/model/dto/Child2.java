package edu.kh.inheritance.model.dto;

// parent를 상속 받겠다
// -> Child2가 parent의 필드, 메서드를 내부에 포함하게 되어 자신의 것처럼 사용
// 단, parent
public class Child2 extends Parent {
	private String house;
	
	 public Child2() {
		 super(); // 상속 관계에서 부모 객체가 먼저 생성 되어야 하기 때문에
		 		// 자식 생성자 첫 번째 줄에 무조건 작성!
		 		// 단, 미작성 시 컴파일러가 추가
		System.out.println("Child2() 기본 생성자로");
	}
	
	public Child2(String house) {
		this.house = house;
		System.out.println("Child2(String) 매개 변수");
	}
	
	public void setHouse(String house) {
		this.house = house;
	}
	
	public Child2(int money, String lastName, String house) {
		
		// 자식 객체 생성 시 
		// 매개 변수가 있는 super() 생성자를 이용해서
		// 부모 객체의 필드도 초기화 할 수 있다.
		
		
		super(money, lastName);
		this.house = house;
	}
	
	public String gethouse() {
		setLastName
		// 부모로부터 상속 받은 멤버(필드, 메서드)를 자식이 자신의 것처럼 사용 가능
		return house;
	}
}
