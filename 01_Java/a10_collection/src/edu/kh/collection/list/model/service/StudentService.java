package edu.kh.collection.list.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.kh.collection.list.model.dto.Student;

/**
 * 
 */
public class StudentService {
	
	// 필드 
	private List<Student> studentList = new ArrayList<Student>(); // 검색 효율이 좋은 리스트
										// new LinkedList<Student>(); // 추가,제거 효율이 좋은 리스트
	
	public StudentService() {
		
		studentList.add( new Student(1, 7, 20, "홍길동", 'M', 97) );
		studentList.add( new Student(1, 7, 11, "김종호", 'M', 85) );
		studentList.add( new Student(2, 5, 10, "김종화", 'M', 87) );
		studentList.add( new Student(5, 2 ,8 , "박장석", 'M', 87) );
		studentList.add( new Student(6, 3 ,2 , "최민지", 'F', 92) );
		
	}
	

	/**
	 * @param grade
	 * @param ban
	 * @param number
	 * @param name
	 * @param gender
	 * @param score
	 * @return
	 */
	public boolean addStudent(int grade, int ban, int number, String name, char gender, int score) {
		
		
		// 전달 받은 값을 이용해서 학생 객체를 만들고
		// studentList에 추가 후 boolean 반환
		//return studentList.add(new Student(grade, ban, number, name, gender, score) );
	// 중복 검사 후 추가하기(업그레이드)
		// 1) 중복 검사 메서드 호출(중복이면 true, 아니면 false)
		// 2) 중복이면 false 반환
		// 아니면 List.add()호출 후 결과 반환
		
	 boolean result = duplicateValidation(grade, ban, name, number, gender, score);
		if(result) { // true인 경우 
			return false;
			
		}
		return studentList.add(new Student(grade, ban, number, name, gender, score) );
	}


	/** 학생 리스트 반환 서비스 메서드
	 * @return studentList
	 */
	public List<Student> selectAllStudent() {
		// TODO Auto-generated method stub
		return studentList; // 학생이 저장된 리스트를 호출한 곳으로 그대로 돌려줌
	}


	/** 인덱스가 일치하는 학생 1명 조회
	 * @param index
	 * @return Student 객체 주소 혹은 null 반환 가능성
	 */
	public Student selectOne(int index) {
		
		// studentList의 index 범위를 넘어선 경우
		if(index < 0 || index >= studentList.size() ) {
			return null;
		}
		
		
		// TODO Auto-generated method stub
		return studentList.get(index);
	}
	
	public Student deleteStudent(int index) {
		
		if(index < 0 || index >= studentList.size() ) {
			return null;
		}
		System.out.println("해당 학생이 삭제 되었습니다.");
		return studentList.remove(index);
	}


	/** 
	 * @param gender
	 * @return
	 */
	public List<Student> selectGender(char gender) {
	
		// 1. studentList에서 학생을 한 명씩 꺼내서 
		// 2. 성별이 gender와 일치하는 학생을
		// searchList에 추가
		// 향상된 for문 : for(요소 1개 참조 변수 : 배열 또는 컬렉션 )
		// -> 매 반복마다 배열 또는 컬렉션의 요소를 
		// 순서대로 하나씩 꺼내어 참조 변수에 대입하는 반복문
		
		List<Student> searchList = new ArrayList<Student>();
		for(Student s : studentList) {
			if(s.getGender() == gender) {
				searchList.add(s);
			}
		}
		
		return searchList;
	}
		
	public List<Student> selectGrade(int grade) {
		List<Student> searchList = new ArrayList<Student>();
		for(Student s : studentList) {
			if(s.getGrade() == grade) {
				searchList.add(s);
			}
		}
		
		return searchList;
	}
	
	public List<Student> selectName(String name) {
		List<Student> searchList = new ArrayList<Student>();
		
		for(Student s : studentList) {
			// String or 객체 값 비교할 때는 A.equals(b) 사용
			
			if(s.getName().equals(name)) {
				
				searchList.add(s);
				
			}
		}
		
		return searchList;
	}
	
	
	// 
	/** 학생 중복 확인 service 메서드
	 * @param grade
	 * @param ban
	 * @param name
	 * @param number
	 * @param gender
	 * @param score
	 * @return 중복이 있다면 True 
	 */
	public boolean duplicateValidation(int grade, int ban, String name, int number, char gender, int score) {
		// 전달 받은 값으로 학생 객체 생성
		Student s = new Student(grade, ban, number, name, gender, score);
		
		// boolean List.contains(요소)
		// 요소가 List 안에 있으면 True, 없다면 False
		
		// contains 사용 조건
		// 비교하려는 객체(클래스)에 Object의 equals()가 오버라이딩 돼 있어야 한다.
		return studentList.contains(s);
	}

// 성적 순서로 정렬 service 메서드
//	정렬된 학생 목록
	
	public List<Student> sortScore() {
		// Objects / Arrays / Collections : 유용한 기능 모음
		// Collections : 컬렉션의 유용한 기능 모음
		// Collections.sort(List) : 원본 List가 정렬
		// -> 이 기능을 사용하려면 
		// List 요소(Student)에 정렬 기준을 정하는 코드가 있어야 한다.
		
		Collections.sort(studentList);
		// 점수가 오름차순으로 정렬된다.
		// 점수를 내림차순으로 정렬한다 Collections.reverse(studentList);
		
		return studentList;
	}
	
	
	
	
}
