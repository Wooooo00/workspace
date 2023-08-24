package edu.kh.collection.set.ex;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.list.model.dto.Student;

public class SetEx {
	
	// 컬렉션 특징 : 크기 제한 X , 다양한 기능, 객체만 저장
	// 제네릭 <T> : 컬렉션 타입 제한
	
	// Set(집합)
	// 중복 데이터가 저장되지 않는다 (같은 객체를 덮어 씌우기 때문)
	// 순서를 유지하지 않는다 ( index 없음)
	// get() 메서드가 없다.
	// 대표적인 자식 클래스
	// HashSet : hashCode()를 이용해서 중복 비교
	// 							빠른 검색 지원
	// linkedHashset : 순서가 유지되는 Set
	// hashCode() 오버라이딩 필수
	
	// TreeSet : 저장되는 값을 자동으로 정렬
	// 			Comparable 상속 필수
	
	public void ex1() {
		Set<String> set = new HashSet<String>();
		
		// String, Integer 등 JAVA 제공 객체들은 
		// 기본적으로 hashCode(), equals(), compareTo() 등이 
		// 오버라이딩 되어 있음
		
		
		// 1. boolean set.add(E e) : 추가
		set.add(" 네이버 ");
		set.add(" 카카오 ");
		set.add(" 라인 ");
		set.add(" 쿠팡 ");
		set.add(" 배달의 민족 ");
		set.add(" 당근마켓 ");
		set.add(" 토스 ");
		set.add(" 직방 ");
		set.add(" 야놀자 ");
		
		// set에 null 저장되지만 1개만 가능(중복 X)
		set.add(null);
	
		// null : 참조하는 객체가 없음 == 주소 저장 X
		
		System.out.println(set);
		
		// 2. int set.size() : 저장된 객체의 수 반환
		System.out.println("size : " + set.size() );
		
		// 3. remove(E e) 
		// e와 똑같은 요소가 set에 있으면 지우고 true를 반환
		
		if(set.remove("직방")) {
			System.out.println("직방이 제거 되었습니다.");
			
			
		} else 
			System.out.println("직방이 없습니다.");
		
		// 4. boolean set.contains(E e) : 
		//  set에 저장된 객체 중 e와 똑같은 객체가 있으면 true, 아니라면 false
		
		System.out.println("네이버" + (set.contains("네이버") ? "있음" :" 없음"));
		System.out.println("네이버" + (set.contains("직방") ? "있음" :" 없음"));
		
		// 5. void set.clear() : set에 저장된 객체를 모두 지움
		set.clear();
		System.out.println("clear 후 size : " + set.size());
		System.out.println("set이" + (set.isEmpty() ? "비어있음" : "비어있지 않음" ));	
 	}
	
	public void ex2() {
		
		// Set에 저장된 값 꺼내 쓰는 방법
		
		// Iterator 
		// 컬렉션 객체의 요소를 하나씩 꺼내서 반복 접근할 수 있는 객체
		// 순서대로 요소 하나씩 꺼내는 객체
		
		Set<String> set = new HashSet<String>();
		set.add("포카칩");
		set.add("몽쉘");
		set.add("오뜨");
		set.add("썬칩");
		
		// Iterator set.iterator() :
		// set의 내용을 순차 접근할 수 있는 형태로 변경해서 반환
		
		Iterator<String> it = set.iterator();
		// Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			
			
			String temp = it.next();
			System.out.println(temp);
		}
		
		// ===============================================================
		
		
		//향상된 for문
		
		System.out.println("------------------");
		
		for(String s :set) {
			System.out.println(s);
	}

	
	}
	
	
	public void ex3() {
		// set이 중복을 확인하는 방법
		// 새로 추가하려는 객체와
		// set에 있는 객체가 
		// equals() 수행시 true
		// hashCode() 비교 시 true이면 중복으로 판단
		
		// Set 이용하려면 equals()와 hashCode() 필수로 오버라이딩
		
		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(3, 4, 5, "홍길동", 'M', 100) );
		set.add(new Student(3, 4, 5, "홍길동", 'M', 100) );	
		System.out.println("size : " + set.size());
		
		for(Student s : set) {
			System.out.println(s);		
		}
		
	}
	
	public void CreateLottoNumber() {
		// 로또 번호(1~45, 6개, 중복X, 오름차순)
		Random random = new Random(); // 난수 생성
		
	//	Set<Integer> lotto = new HashSet<Integer>();
		Set<Integer> lotto = new TreeSet<Integer>(); // 오름차순으로 정렬
		
		// 컬렉션은 기본 자료형 저장이 불가하기 때문에 Wrapper 클래스를 이용한다.
		
		while(lotto.size() < 6 ) {
			lotto.add( random.nextInt(45) + 1 );
		}
		System.out.println(lotto);		
	}
	
	public void lottoVersion2() {
		
		Random number = new Random();
		// 금액을 입력 받아서 
		//3000원이면 3회 5000원이면 5회
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("금액을 입력하세요 : ");
			int input = sc.nextInt();
			
			if(input < 1000) {
				System.out.println("1000 이상만 입력 해주세요");
				return;
			}
			
		}catch (InputMismatchException e) {
			System.out.println("오류");
		// 	sc.nextLine(); 입력 버퍼에 남은 문자열 제거
		}
		// for(int i = 1; i<=price/1000 ; i++) {
		
		Set<Integer> lotto = new HashSet<Integer>();
		
		while(lotto.size() < 6 ) {
			lotto.add( number.nextInt(45) + 1 );
			
			//if(input == ) {
				
			}
				
				
			
			
		}
		
						
			
		}				
		
	


