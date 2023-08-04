package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPractice {
	
	
	//실습 문제1
	public void practice1() { 
		// 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[숫자를 한 개 입력하세요] : ");
		
		int input = sc.nextInt();
		
		if(input > 0 && input % 2 == 0) {
			
			System.out.print("짝수입니다.");
		} if(input > 0 && input % 2 != 0) {
			System.out.print("홀수입니다.");
		} else { 
			System.out.print("양수만 입력해주세요.");
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	// 실습 문제2
	public void practice2() { 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("[실행 화면 1]");
		System.out.print("국어 점수 : ");
		int input1 = sc.nextInt();
		System.out.print("수학 점수 : ");
		int input2 = sc.nextInt();
		System.out.print("영어 점수 : ");
		int input3 = sc.nextInt();
		
		
	
		// System.out.printf("국어 : %d \n" , input1 );
		// System.out.printf("평균 : %d \n ",(input1 + input2 + input3) / 3);
		
		//("1인당 사탕 개수 : %d \n ", candy/count);
				
		// 인풋 1,2,3 < 40 && (인풋1 + 2 + 3) / 3 < 60 아닐 경우 합격 
		// 0 <= 점수 <= 100이 아닌 경우 오류 
		
		    System.out.printf ("평균 : %d \n ", (input1 + input2 + input3) / 3);
		
		if(input1 < 40  || input2 < 40 || input3 < 40 || (input1 + input2 + input3) / 3 < 60) { 
			System.out.print("불합격");
			 
			 
		}if(input1 > 40  && input2 > 40 && input3 > 40 && (input1 + input2 + input3) / 3 > 60) {
			System.out.print("합격");
			
			
			
		}
		
		
		 
		
		
		
		
		
		
	}
	
	// 실습 문제3
	public void practice3() { 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		
		//int day = 0; sc.nextInt(); // 해당하는 달의 마지막 일(날짜)를 저장, 단 1~12월이 아니면 0을 저장
		System.out.println();
		switch(month) { 
		case 1: case 3: case 5: case 8: case 10: case 12:
			day = 31; break;
		case 4: case 6: case 9: case 11: day = 30; break;
		case 2: day = 28; break;
		// default : 
		}
		if(day == 0) { // 1~12 가 아닐 때 
			System.out.printf("%d월은 잘못 입력된 달입니다", month);
			
		}else { // 1~12 사이가 입력 
			System.out.printf("%d월은 %d일까지 있습니다.", month, day);

		}
		
		
		
		
		
		
		
	}
	
	// 실습 문제4
	public void practice4() { 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키");
		double height = sc.nextDouble();
		
		System.out.print("몸무게");
		double weight = sc.nextDouble();
		
		double bmi = weight / (height * weight);
		
		String result; // 결과 저장
		
		if(bmi < 18.5) { 
			result = "저체중";
			
		}else if(bmi >= 18.5 && bmi <23) {
			result = "정상";
		
		}else if(bmi > 23 && bmi <25) {
			result = "과체중";
		
		}else if(bmi > 25 && bmi <30) {
			result = "비만";
					
		}
		
		System.out.println("BMI 지수 : " + bmi);
		System.out.println(result);
		
		
				
		
		
		
		
		
	}
	
	// 실습 문제5
	public void practice5() { 
		Scanner sc = new Scanner(System.in);
	
		System.out.print("중간");
		int mid = sc.nextInt();
		System.out.print("기말");
		int fin = sc.nextInt(); 
		System.out.print("과제");
		int assi = sc.nextInt(); 
		System.out.print("출석");
		int att = sc.nextInt(); 
		
		System.out.println("결과");
		
		//출결이 안 될 때
		if(att <= 20 * (1 - 0.3)) {
			System.out.printf("[출석 횟수 부족 (%d/20]", att);
		}else { //출석은 충족
			
			double mids = mid * 0.2;
			double fins = fin * 0.3;
			double assis = assi * 0.3;
			double atts = att * 5 * 0.2;
			
			double sum = mids + fins + assis + atts;
			
			System.out.println("중간 : " + mids);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			
		}
		
		}
	
	//---------------------------------------------------
	/*public void 연습1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력: ");
		int input = sc.nextInt();
		
		if(input > 0 && input % 2 == 0) {
			System.out.println("짝수입니다.");
			
			
		}else if(input > 0 && input % 2 != 0) {
			
		}else {
			System.out.print("양수만 입력 가능");
		}
	}
		// if(input > 0) { 
		// if(input % 2 == 0) {
		
		// String result;
		// result로도 결과 표현 가능
		 * 
		 * pr2 
		 * 
		 * 합계 : int sum = K + E + M 
		 * 평균 : double avg sum / 3.0 
		 * 합격여부 
		 * if(K >= 40 && M >= 40 && E >= 40 avg >= 60.0 { 
		 * System.out,println("국어: 
		 * System.out,println("수학: 
		 * System.out,println("영어: 
		 * System.out,println("합계: 
		 * System.out,println("평균: 
		 * System.out,println("축하합니다 합격입니다: 
		 *
		 * pr3
		 * 
		 * 
		 * 
        */
	

}
