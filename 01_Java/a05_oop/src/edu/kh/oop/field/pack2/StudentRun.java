package edu.kh.oop.field.pack2;

public class StudentRun {
	
	public static void main(String[] args) {
		
		// student 객체 생성
		Student s1 = new Student();
		s1.grade = 3;
		s1.ban = 5;
		s1.number = 12;
		s1.name = "홍길동";
		
		// static : 같은 타입의 객체끼리 필드 공유 목적
		// 프로그램 실행 시 static 영역에 생성되고
		// 프로그램이 끝나기 전까지 고정(사라지지 않는다)
		// 고정된 static 프로그램 어디서든 공유 가능 (공유 메모리 영역)
		
		public static String schoolName = "중구 중학교" ;
		
		// 클래스 초기화 변수
		
	static {
		
		
		//name = "abc"; 인스턴스 변수는 클래스 초기화 불럭에서 초기화 불가능
		
		schoolName = "서울 중구 중학교"; 
		
	}		
				
				
		// 클래스 변수
		// 필드에 작성되고 static이 붙은 변수
		// static 
		
			
			//s1.schoolName = "중구 중학교";
			
			Student s2 = new Student();
			s1.grade = 1; // 학년 / 필드에 3 대입을 직접 잓
			s1.ban = 1;
			s1.number = 7;
			s1.name = "고길동";
			s1.schoolName = "";
			
			// static이 붙은 필드를 다룰 때는 클래스명.필드명으로 작성을 권장
			//Student.schoolName = "중구 외국어 중학교";
			
			System.out.println("--- 변경 전 학교명 ");
			System.out.println(s1.schoolName);
			System.out.println(s2.schoolName);
			
			
			
			// schoolName 필드를 static으로 변경하면 
			// 한 학생의 학교명만 변경해도 모두 바뀌게 됨
			
			
			
			
			
			
		}
			
			
		}
		
	

}
