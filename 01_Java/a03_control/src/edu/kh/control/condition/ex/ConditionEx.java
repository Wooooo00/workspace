package edu.kh.control.condition.ex;

import java.util.Scanner;

// 실행 기능 담당
public class ConditionEx {

	public void test1() {
		System.out.println("test1 수행");

	}

	public void test2() {
		System.out.println("test2 수행");

	}

	// if 예제 1
	public void ex1() {

		// 입력 받은 수가 양수인지 아닌지 검사
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 :");
		int input = sc.nextInt();

		/* 조건식 */
		if (input > 0) { // input이 0보다 커서 조건식이 true인 경우 수행

			System.out.println("양수입니다");
			System.out.println("ex1() 종료");

		}

		if (input <= 0) {
			System.out.println("양수 x");
		}

	}

	// if 예제 2 - if - else
	// if : 조건식이 true인 경우 수행
	// else : 조건식이 false인 경우 수행

	public void ex2() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		if (input > 0) { // 양수인 경우
			System.out.println("양수입니다");
		} else { // if 조건식이 faslse인 경우 수행
					// else는 조건식을 따로 적지 않음
			System.out.println("양수가 아닙니다");

		}
	}

	// if 예제 3 - 중첩 if문
	public void ex3() {
		// 양수, 음수, 0 구분

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 :  ");
		int input = sc.nextInt();

		if (input > 0) {
			System.out.println("양수입니다.");
		} else {

			if (input == 0) {
				System.out.println("0입니다.");
			} else {
				System.out.println("음수입니다.");
			}
		}
	}

	
	// if 예제 4 - if - else if - else
	public void ex4() { 
		// 달을 입력받아 해당하는 달의 계절을 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("달을 입력해주세요 : "); 
		int month = sc.nextInt();
		
		String season; // 변수 선언
		               // 아직 초기화 하지 않음 -> 조건문 작성 과정에서 할 예정
		
		if(month >= 3 && month <= 5 ) {// 봄 3,4,5 
			season = "봄"; 
		}
		else if(month >= 6 && month <= 8) {
			season = "여름";
	    }
		else if(month >= 9 && month <= 11) {
			season = "가을"; 
		}
		else if(month == 12 || month == 1 || month == 2) {
			season = "겨울";
		}
		else { 
			season = "오류";
		}
		
		System.out.println(season);
		
		// 선언된 변수(지역 변수)는 반드시 사용되기 전 초기화 되어야 한다. 
		
	}
	// --------------------------------------------------------------------------
	
	// if 예제 5 
	// 나이를 입력 받아 13세 이하 -> "어린이" 
	// 13세 초과 19세 이하면 "청소년" 
	// 19세 초과는 "성인" 
	// 0세 미만, 100세 초과는 "잘못 입력"
	public void ex5() { 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이를 입력해주세요. ");
		
		int age = sc.nextInt();
		
		String group;
		
		if(age <= 13 && age <= 0) { 
			group = "어린이";
			
		}
		
		else if(age < 19 && age > 13) {
			group = "청소년";
		
		}
		
		//else if(//age <= 100 && //age > 19) { 
			group = "성인";
	
		}
		
		//else {
			group = "0 ~ 100사이의 수를 입력";
		}
		
	
		System.out.println(group);
		
		
		// -------------------------------------------------------
		
		/*if(age <= 13) {
			System.out.println("어린이");	
		} else if(age > 13 && age <= 19) {
			System.out.println("청소년");
		} else {
			System.out.println("성인");
		}
		
		if(age < 0 || age > 100) { 
			System.out.println("오류");
		} else { 
			
		}
	    */
		
		
		
	
	// ----------------------------------------------------------------------------
	//if 예제 6번 
	public void ex6() { 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나이를 입력해주세요. ");
		int age = sc.nextInt();
		
		
		
		
		
		System.out.println("키를 입력해주세요. ");
		double height = sc.nextDouble();
		
		
		
		
		
		
		
		System.out.println(age);
		System.out.println(height);
		
		
		
	}

	// 나이가 12세 이상이면서 키가 140.0 이상인 사람 
	
  //if 나이가 12미만 
	
	
	
	// ----------------------------------
	
	// if(age >= 12 && height >= 140.0) { 
	// System.out.println 
	
	// else if (age < 12) { 
	
	// else 
	

	
	
	
	
	
	
	
	
	
	
}
