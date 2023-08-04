package edu.kh.oop.method;

public class PersonServiceRun {
	
	public static void main(String[] args) {
		
		
		// PersonService 객체 생성
		PersonService service = new PersonService();
		
		// PersonService 객체에 생성자로 초기화된 title을 얻어와 출력
		
		String title = service.getTitle();
		System.out.println(title);
		
		// PersonService의 createPerson을 이용해서 
		// person 객체를 생성하여 반환 받기
		Person p1 = service.creatPerson();
		// 생성된 Person 객체의 주소를 반환 받음
		// 얕은 복사 : 객체 참조 주소만 복사
		
		// 생성한 Person 객체의 필드 값을 하나의 문자열로 얻어와 
		// 화면에 출력
		String str = service.personFields(p1);
		System.out.println(str);
		
		
	}

}
