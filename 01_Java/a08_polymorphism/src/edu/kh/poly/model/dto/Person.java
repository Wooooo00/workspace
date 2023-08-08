package edu.kh.poly.model.dto;

// 클래스, 추상 클래스를 상속 받을 때는 extends를 사용

public class Person extends Animal {
	
	public Person() {
		super(); // Animal 호출
	}

	public Person(String string, String string2, String string3, int i) {
		// TODO Auto-generated constructor stub
	}

	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	// Animal로부터 상속 받은 breath 메서드를 
	// 오버라이딩(구현, 정의)하라고 강제되고 있음
	// 
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", getName()=" + getName() + ", getAge()=" + getAge()
				+ ", getType()=" + getType() + ", getEatType()=" + getEatType() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	@Override
	public void breath() {
		
		System.out.println("사람 : 코와 입으로 숨을 쉼");	
	}

	
		
	

	
	
}
