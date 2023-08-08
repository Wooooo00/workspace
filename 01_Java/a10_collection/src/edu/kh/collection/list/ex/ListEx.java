package edu.kh.collection.list.ex;

import java.util.ArrayList;
import java.util.List;

public class ListEx {
	
//	컬렉션 특징
//	1) 크기 제한 X
//	2) 추가,수정,삭제 등의 코드가 구현 되어 있다
//	3) 객체만 저장 가능
//	
//	List : 자료를 순차적으로 나열한 자료구조(배열과 비슷)
//	특징1 : 인덱스를 이용해서 순서를 구분 
//	특징2 : 순서가 구분되기 때문에 중복 데이터 저장 가능
//	
//	

	public void ex1() {
		
		// 다형성 적용
		//List list = new ArrayList(); // 기본 10칸 생성
		List list = new ArrayList(3); 	// 3칸 생성
		
		// 1. boolean add(E e) : 마지막 요소로 추가
		// E(element) : 요소를 뜻하는 상징적인 글자(자료형 X)
		// -> Object를 생각하면 편함
		list.add("아무거나"); // String은 객체
		list.add(123); // int 기본 자료형 int -> Integer 
		list.add(3.14); // double 기본 자료형 
		
		// 컬렉션에 저장되는 객체의 타입 제한 X 
		
		// 왜? 기본 자료형이 저장될까? 
		// --> Wrapper Class (감싸는 클래스)
		
		
		System.out.println(list);
		
		// list의 크기 3을 초과해서 추가해도
		// 자동으로 크기가 늘어나서 에러 발생 X 
		list.add("크기 3 초과");
		System.out.println(list);
		
		
		// 2. E get(int index) : 지정한 index 요소 얻어오기 
		System.out.println(list.get(2) );
		System.out.println(list.get(1) );
		System.out.println(list.get(0) );
		
		System.out.println("==========================");
		
		// 정말 자동 포장이 되었는지 확인
		System.out.println(list.get(1) instanceof Integer );
		System.out.println(list.get(2) instanceof Double);
		
		// List + for문 + if + instanceof + 다운캐스팅
		
		// int list.size() : 
		for(int i = 0 ; i < list.size(); i++) {
			
			if(list.get(i) instanceof String) {
				String s = (String)list.get(i);
				
				System.out.println("첫 글자 : " + s.charAt(0));
			}
			
			if(list.get(i) instanceof Integer) {
				int number = (Integer)list.get(i);
				
				System.out.println(100 + number);
			}
			
			if(list.get(i) instanceof Double) {
				Double d = (Double)list.get(i);
				System.out.println(d.BYTES + "바이트");
			}
			
		}
		
		
		
	}
	
	
}
	
//기본 자료형      Wrapper Class  소문자로 시작하는 기본 자료형에서 -> 대문자로 바꿔주면 Wrapper Class
//boolean 		Boolean		
//byte			Byte
//short			Short
//int			Integer
//long			Long
//float			Float	
//double		Double
//char			Character

// 기본 자료형을 -> 래퍼 클래스로 : Boxing
// 래퍼 클래스를 -> 기본 자료형으로 : Unboxing 
// 상황에 따라 자동으로 기본 <-> 객체가 되도록 구현됨
// 이것을 Auto Boxing, Auto Unboxing 이라고 한다. (컬렉션에서 많이 사용)

