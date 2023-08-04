package edu.kh.control.loop.ex;

import java.util.Scanner;

public class LoopEx {
	
	// for문 
	// 끝이 정해져 있는 경우에 사용하는 반복문
	// 몇 번 반복할지 알고 있을 때
	// [작성법]
	// for(초기식 ; 조건식 ; 증감식 ){ 
	//	   조건이 true일 경우 수행할 코드 ( + 반복)
	
	// 초기식 : 
	// 조건식 :
	// 증감식 :
	
	public void ex1() {
		// 안녕하세요 10번 출력하기 
		
		for(int i = 1 ; i <= 10 ; i++) {
			System.out.println("안녕");
			
		}
	}
	// for문 해석 순서
	// 1) 초기식 (반복을 세는 용도의 변수)
	// 2) 조건식 (초기식에 사용된 변수의 값에 따라 반복 여부 결정)
	// 3) for문 내부 코드
	// 4) 증감식 (초기식 변수의 값을 변화) 
	// 2~4 반복 (조건식이 false가 나올 때까지)
	
	// for 예제 2) 1~10까지 출력  
	// 초기식에는 보통 시작하려는 숫자를 대입 
	
	public void ex2() {
		for(int i = 1 ; i <= 10 ; i++) {
			System.out.println(i);
		}
		
		
	}
	
	public void ex3() {
		for(int i = 3 ; i <= 8 ; i++ ) {
			System.out.println(i);
		}
	}

	public void ex4() {
		int sum = 0;
		for(int i = 2 ; i <= 20 ; i++) {
			sum = sum + i;
			System.out.println("합계 : " + sum);
		}
	}
	
	public void ex6() {
		int sum = 0;
		for(int i = 50 ; i <= 100 ; i++) { 
			sum += i; // sum에 i값 누적
		}
		System.out.println("50~100의 합 :" + sum);
	
	}
	
	// 3부터 30까지 3씩 증가 + 출력되는 수의 합을 마지막에 출력
	public void ex7() {
		int sum = 0;
		for(int i = 3 ; i <= 30 ; i += 3) { 
			System.out.println(i);
			sum += i;
		}
		 
			System.out.println("합계: " + sum);
			
		
		
	}
	
	// 시작, 끝, 증가할 수를 입력 받아
	// 지정된 범위까지 모두 출력 후 
	// 합계도 출력
	
	//ex) 시작: 1
	// 끝: 5
	// 증가할 수 : 2
	// 1 3 5
	// 합계 : 9
	public void ex8() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		System.out.print("시작: ");  // System.out.print("숫자 입력: ");
		int start = sc.nextInt();   
		
		System.out.print("끝: ");
		int end = sc.nextInt();
		
		System.out.print("증가할 수: ");
		int step = sc.nextInt();
		
		for(int i = start ; i <= end ; i += step) {
			System.out.println(i + " ");
			sum += i;
			
		}
		 System.out.println("\n합 : " + sum);
	}
	
	
	

	// --------------------------------------------------------------------------	 
		 
	 // 1부터 10까지 모든 정수 출력 
	 // 단, 짝수는 [] 감싸서 출력
	
	// / 2 % == 0
	
	
	public void ex9() { 
			
		for(int i = 1 ; i <= 10 ; i++) {
				
		if(i % 2 == 0) { 
			System.out.printf("[%d] ",i);
		}
		else {
			System.out.printf("%d ",i);
			 
		 }
	}
	
	// ------------------------------
	// 1부터 10까지 모든 정수 출력
	// 단, 홀수는 () 감싸서 출력한다.
	// 1은 "시작" 10은 "끝" 이라고 출력한다 
    // 
	
	//public void ex10() {
		
	 //for(int i = 1 ; i <= 10 ; i++) {
	 
	// if(i % 2 == 0) {
	//	System.out.printf("%d" , i);
	//} else 
	//	System.out.printf("%d", i));

	//}else 
	 
	// else
	 
	//}
//}


	
	
	
	
	/* -------------------
	public void ex10() {
		
		 for(int i = 1 ; i <= 10 ; i++) {
			 
		 if(i % 2 == 0 { 
			 System.out.printf()
					 
		 }else
      // -----------------------------------------------
			 
 public void ex11() {

		for(int i = 1 ; i <= 10 ; 1++) { 
		*/	 
		 
	     // 1부터 20까지 1씩 증가하는 반목문을 이용해
		 // 짝수의 합, 홀수의 합을 구해서 입력 

	     // 변수 , 변수 % 2 != 0 홀
		



//public void ex11() {
			 //int sum = 0;
			// int sum2 = 0;
			// for(int i=1; i<=20; i++) {
				 
			//	 if( i % 2 == 1) {
			//		 sum1 += i ;
					 
					 
			//		if(i)
		//	 } else { 
		
				 
			 }
				 
				 
		// System.out.println("짝수의 합 : ");
		// System.out.println("홀수의 합 : ");

	//	 System.out.println();

//			 }
//		 }       


//
// 1부터 100까지 1씩 증가하는 
// 1~100 사이 입력 받은 수의 배수를 뺀 나머지 수의 합을 출력
	// public void ex12() {
		
		
		//Scanner sc = new Scanner(System.in);
	//	int sum = 0;
		 
		 // int sum = 0;
		
		//System.out.print("제외할 배수 입력 : ");
		//int num = sc.nextInt();
		
		//for(int i = 1 ; i <= 100 ; i++) {
		
		
		// if % num != 0 -> +=
		// 
		//% num != 0 -> 
		// % num == 0 제외 
		
	

			 
	
	 
	 
	 public void ex12() {
		 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 }	 
			 

			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
	
 }