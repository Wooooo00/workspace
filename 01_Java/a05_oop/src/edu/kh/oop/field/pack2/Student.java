package edu.kh.oop.field.pack2;

public class Student {
	
	// 필드(속성)
	
	// 인스턴스 변수 : 인스턴스(객체) 생성 시 메모리에 할당되는 변수
	
	// -> 필드에 작성되고 static이 없는 건 다 인스턴스 변수
	public int grade; // 학년
	public int ban; 
	public int number; 
	public String name;
	

	// 인스턴스 초기화 블럭
	// 인스턴스 생성시
	// 인스턴스 변수 (static 없는 필드)를 초기화 하는 용도
	
	grade = 5;
	ban = 2;
	public static String schoolName = "중구 중학교";
	
	public void study() {
		
		System.out.println("열공");
		
		
	}
	

}


