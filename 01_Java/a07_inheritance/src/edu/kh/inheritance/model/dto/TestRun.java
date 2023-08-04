package edu.kh.inheritance.model.dto;

import edu.kh.inheritance.model.dto.*;
public class TestRun {
	
	public static void main(String[] args) {
		
		// 부모 객체 생성
		Parent p1 = new Parent();
		Parent p2 = new Parent(100, "하");
		// ctrl + shift + o : import 자동 추가
		System.out.println("=======");
		
		Child c1 = new Child("G");
		Child c2 = new House("시그니엘");		
	}
	 	System.out.prinln("---------");
	 	
	 	Child3 c3 = new Child2(900, "김", "원룸");
// 자식 객체를 만들었기 때문에 
// 자식의 생성자가 실행되는 건 이해되는데 
// 왜? 부모의 생성자가 기본 생성자가 같이 실행 됐을까
// 
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	
	
	
}
