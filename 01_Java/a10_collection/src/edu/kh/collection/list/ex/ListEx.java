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
	
	public void ex2() {
		// 컬렉션의 장점인 "여러 타입 저장 가능"
		// 때문에 instanceof로 타입 검사를 해야하는 코드가 추가되어 
		// 코드 길이가 늘어나는 문제점이 발생
		// -> 그래서 타입을 하나로 제한
		// -> Generics을 이용
		
		// String으로 저장되는 타입이 제한된 List
		// 컴파일 단계에서 강력한 타입 체크
		
		List<String> list = new ArrayList<String>();
		
		list.add("닭갈비");
		list.add("삼계탕");
		list.add("치킨");
		list.add("보쌈정식");
		list.add("샐러드");
		
		// list.add(int index, E e) : 중간에 추가(삽입)
		list.add(0, "곰탕");
		list.add(3, "카레");
		
		// E list.set(int index, E e) : 지정된 index의 요소를 바꿈(수정)
		// 반환되는 값은 바뀌기 이전 요소
		
		String before = list.set(1, "치즈 닭갈비");
		System.out.println("before : " + before);
		
		// E list.remove(int index) : 
		// index번에 있는 요소를 List에서 제거
		// 반환되는 값은 제거된 요소
		
		String target = list.remove(6);
 		System.out.println(target + " 제거");
 		
 		// boolean list.contains(E e) : 
 		// list에 요소가 포함되어 있는지 확인
 		System.out.println(list.contains("삼계탕"));
 		System.out.println(list.contains("누룽지 삼계탕"));
 		
 		// int list.indexOf(E e) : 
 		// list에 요소가 존재하면 해당 index 반환
 		// 없으면 -1 반환
 		System.out.println(list.indexOf("삼계탕"));
 		System.out.println(list.indexOf("누룽지 삼계탕"));
 		
 		// void list.clear() : 요소 모두 삭제
 		list.clear();
		
 		// boolean list.isEmpty() : 
 		// 비어 있으면 true 아니면 false
 		System.out.println("비어있음?" + list.isEmpty());
 		
		
		for(int i = 0 ; i < list.size() ; i++) {
			// list.get(i)
			// -> String으로 제한된 리스트 요소를 꺼내오기 때문에
			// 꺼낸 요소의 자료형은 무조건 String
			
			System.out.printf("[%d] : %s \n", i , list.get(i));
			
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

