package edu.kh.oop.cls.pack2;

import edu.kh.oop.cls.pack1.ClassTest1;
// ClassTest1 클래스를 가져오는 코드

public class TestRun2 {
	
	public static void main(String[] args) {
		
		ClassTest1 c1 = new ClassTest1();
		c1.method1();
		
		// ClassTest1 객체 생성
		// 다른 패키지 		
		// public은 어디서든 접근 가능한데 생성 불가로 뜨는 이유	
		// 패키지가 다른 클래스 접근하고자 할 때 import라는 작업을 하여 가져와 사용		
		
		
		// ClassTest2 객체 생성
		ClassTest2 c2 = new ClassTest2();
		//		default 접근 제한자 : 같은 패키지에서 접근 가능
		//		같은 패키지는 import 필요 없음
		c2.method2();
		//		
		//		
		//		
		//		
		//		
		
		
	
	}

}
