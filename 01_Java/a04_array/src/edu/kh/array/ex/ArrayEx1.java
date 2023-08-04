package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx1 {
	
	/*  배열(자료구조): 같은 자료형의 변수를 하나의 묶음으로 다루는 것 
	 * 	묶여진 변수들은 하나의 이름(배열명)으로 불려지고 
	 * 	각 변수들은 index를 이용해서 구분하게 된다
	 * (index : 색인, 자료의 위치)
	 * index의 번호는 0부터 시작
	 */
	
	// 배열 할당, 선언, 초기화
	public void ex1() {
		
		//변수 선언
		int a; a = 10; // int 자료형을 저장할 변수 a 선언(메모리 안에 공간 할당)
		// 배열 선언
		int[] arr; // int 자료형 변수를 묶어서 다루는 배열(arr)을 선언
		// int[] -> 참조형
		
		// 변수 대입(== 값 자체를 대입)
		a = 10;
		// 배열 대입(== 할당)
		arr = new int[3];
		// new 연산자 : Heap 영역에 새로운 메모리를 할당
		// (메모리 할당 : 메모리 공간을 차지한다)
		// int[3] : int 변수 3칸짜리 배열
		// new int[3] : Heap 영역에 int 변수 3칸짜리 배열을 새롭게 할당
		// -> 할당된 배열에 시작 주소가 생김
		// arr = new int[3] 
		// new int[3]에 생성된 배열의 시작 주소를 
		// arr에 대입
		// -> arr 호출 시
		// arr에 저장된 주소를 참조해 Heap 영역에 할당된 배열을 찾아간다
		// 이러한 과정 때문에 int[]를 "참조형"이라고 한다.
		
		// *배열 다루기*
		System.out.println("arr : " + arr);
		
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[1] : " + arr[1]);
		System.out.println("arr[2] : " + arr[2]);
		
	}
	
		// 배열 선언 및 할당 + 직접 초기화 
		public void ex2() {
			
			// int 자료형 4개를 묶음으로 다루는 배열 numbers를 선언 및 할당
			
			int[] numbers;
			numbers = new int[4]; // 한 줄 ver -> int[] numbers = new int[4]; 선언 및 할당
					// new 연산자 : Heap 영역에 메모리를 새롭게 할당
			
			// 배열 직접 초기화
			
			numbers[0] = 10;
			numbers[1] = 100;
			numbers[2] = 1000;
			numbers[3] = 10000;
			
			// * 인덱스는 0부터 시작해서 
			// 배열의 크기(길이) -1까지이다. 
			
			System.out.println(numbers[0]);
			System.out.println(numbers[1]);
			System.out.println(numbers[2]);
			System.out.println(numbers[3]);
						
			// 배열 + 반복문(for)
			//for(int i=0 ; i<=3 ; i++) {
				
			// 배열 + 반복문(for) 내림차순
			for(int i=3 ; i>=0 ; i--) {
				System.out.printf("numbers[%d] = %d \n", i , numbers[i]);
			}
		}
		
		// 3명의 키를 입력 받아 
		// 입력 받은 키 + 평균 키 출력(배열 이용)
		public void ex3() {

			Scanner sc = new Scanner(System.in);
			// double형 배열을 참조할 변수 heightArray 선언(주소 저장)
			// Heap 영역에 double 3칸짜리 배열을 생성하여 그 주소를 heightArray 저장
			double[] heightArray = new double[3];
			
			for(int i=0 ; i<3 ; i++) {									
				
				System.out.print(i + "번 키 입력 : ");
				heightArray[i] = sc.nextDouble();
				
			}
			double sum = 0.0;
			
			System.out.println("==================");
			
			// 배열명.length : 배열의 길이(크기)를 반환 
			
			for(int i=0 ; i<heightArray.length ; i++) {
				System.out.printf("[%d번째의 키] = %.1f \n", i, heightArray[1]);
				// 소수점아래 한 자리까지만 출력
				sum += heightArray[i]; // 합계
			}
			
			System.out.println("평균 :  " + sum/3.0);
			
			
		}
			
		//점심 메뉴 뽑기 프로그램
		// 배열 선언과 동시에 초기화

		public void ex4() { 
			// 문자열 배열 선언 및 할당 
//			String[] menuArray = new String[5];
			
//			menuArray[0] = "햄버거";
//		    menuArray[1] = "돈까스";
//		    menuArray[2] = "제육";
//			menuArray[3] = "샐러드";
//			menuArray[4] = "스시";
			
			// 배열 선언과 동시에 초기화 
			String[] menuArray = {"햄버거", "돈까스", "제육", "샐러드", 
									"국밥", "김밥", "라면", "스시"};
			
			// 배열 index 범위 안의 난수를 발생
			int index = (int)(Math.random() * menuArray.length);
			// (int)(0.0 <= x < 5.0)
			// (0.0 <= x < 5.0) -> 0 1 2 3 4 5
			
			System.out.println("오늘의 메뉴 : " + menuArray[index]);
		}
		
		// 분식집 주문 프로그램
		public void ex5() {
			// 배열 2개를 생성 후 
			// 같은 인덱스 번호에 메뉴명, 가격을 작성
			String[] menus = {"참치김밥", "김밥", "돈까스김밥","라볶이", "고구마돈까스"};
			
			int[] prices = {4000, 2500, 4000, 5000, 8000};
			
			String orderMenu = ""; // 주문한 메뉴를 저장할 변수
			int sum = 0; // 주문한 메뉴의 가격을 저장할 변수
			
			while(true) { 
				System.out.println("-----메뉴-----");
				
				for(int i = 0; i < menus.length ; i++) {
					System.out.printf("%d) %s (%d)원 \n", i, menus[i], prices[i]);
				} System.out.println("9) 주문 완료");
				
			 	  System.out.print("메뉴 선택 >> ");
			 	  Scanner sc = new Scanner(System.in);
			 	 
			 	  int input = sc.nextInt();
			 	  
			 	  //만약 9면 반복 멈춤
			 	  if(input ==9) { 
			 		  break;
			 	  }
			 	  
			 	  //메뉴 인덱스 범위를 초과할 때 "잘못 입력" 출력
			 	  else if(input < 0 || input >= menus.length) {
			 		  System.out.println("잘못 입력");
			 	  } else { // 정상 입력
			 		  orderMenu += menus[input] + " "; 
			 		  sum += prices[input];
			 		  
			 	  } // while 종료
			 	  
			 	  
				
			}
			
		}
		
			// 입력받은 양의 정수만큼의 크기를 가지는 배열 만들기
			
				
// 	평균 점수 구하기
// 	입력 받을 인원 수 : 4 
//	1번 점수 입력 : 100
//  2번 점수 입력 : 20
//	3번 점수 입력 :			
//				
		public void ex6() {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("입력 받을 인원 수 : ");
			int num = sc.nextInt();
			
			int[] scores = new int[num]; // 입력 받을 수만큼의 길이를 가지는 배열
			
			// sum 선언 초기화
			
			int sum = 0;
		
			for(int i=0 ; i<scores.length ; i++) {
				System.out.print( (i+1) + "번 점수 입력 : " );
				scores[i] = sc.nextInt(); // 입력 받은 정수를 배열 요소 저장
			//	scores : 배열명
			// 	i : 인덱스
			//	scores[i] : scores의 i번째 요소
				sum += scores[i]; // 합계 누적
			} 
			System.out.println("합계 : " + sum + " 점");
			System.out.println("평균 : " + sum/scores.length + " 점");
			
			}
		
		/* 생성할 배열의 길이 : 3
		 * 0번 인덱스 요소 : 40
		 * 1번 인덱스 요소 : 60
		 * 2번 인덱스 요소 : 80 
		 * 저장된 값을 확인하는 인덱스(-1 입력 시에 종료) : 0
		 * 잘못 입력 했을 때 값도 저장 
		 * 
		 * 배열 3 생성 -> 0 입력 40, 1 입력 60, 2입력 80
		 */
		
		public void ex7() {
			Scanner sc = new Scanner(System.in);
			
			
			System.out.print("생성할 배열의 길이 : "); 
			int input = sc.nextInt();
			int[] arr = new int[input];
			
			// 생성된 배열의 모든 요소에 입력 값을 대입
			for(int i=0 ; i<arr.length ; i++) { 
				
				System.out.print(i + "번 인덱스 요소 : ");
				arr[i] = sc.nextInt();
				
			}
			
			while(true) { // 무한 반복
				System.out.print("저장된 값을 확인하려는 인덱스");
				int index = sc.nextInt();
				// 무엇을 입력 했는가에 따라서 동작을 구분 
				
				if(index == -1) {
					System.out.println("프로그램 종료");
					break;
				}
				
				if(index < 0 || index >= arr.length) { 
					
					
				}
				
				
				
				
			}
			

			for(int i=0; i>= 3; i++) {
				
				
			}
			
			
			
		}
			
		// ---------------------------------------------------------------------------	
		
		public void ex8() {
			
		// 얕은 복사 	
		// 서로 다른 참조 변수가 하나의 배열을 참조하게 만드는 것	
		// 특징 : 하나의 배열을 참조하기 때문에 값을 공유함
		// 
		int[] arr = {10,20,30,40,50};
		// 얕은 복사
		int[] copyArr = arr; // arr에 저장된 주소를 copyArr
		
		System.out.println(arr); // arr에 저장된 주소값 (해시코드)
		System.out.println(copyArr); // copyArr에 저장된 주소값 (해시코드)
		System.out.println(arr == copyArr); 
		
		// arr을 이용해서 배열에 저장된 값 변경
		arr[0] = 99;
		arr[1] = 1234;
		
		// Arrays 클래스 : 배열 관련 기능을 모아둔 클래스(자바에서 제공)
		// Arrays.toString(배열명) : 배열에 저장된 값을 하나의 문자열로 반환
		
		System.out.println(Arrays.toString(arr));
		
		System.out.println(Arrays.toString(copyArr));
		
		}
	
		public void ex9() {
			
			// 깊은 복사 
			// 원본과 같은 참조형 변수와
			// 원본과 같거나 더 큰 배열을 만들어 
			// 원본에 데이터를 모두 복사하여 참조하는 방법
			
			int[] arr = {10,20,30,40,50};
			// 1. for문을 이용한 깊은 복사
			int[] copyArr1 = new int[arr.length]; // arr.length
			
			for(int i=0 ; i<arr.length ; i++) {
				
				copyArr1[i] = arr[i]; // 원본값을 복사본에 대입(복제)
			}
			
			// 2.System.arraycopy(원본 배열명, 원본 복사 시작 인덱스, 복사 배열명, 
			//						복사 배열명의 삽입 시작 인덱스, 복사 길이)
			
			int[] copyArr2 = new int[arr.length];
			
			System.arraycopy(arr, 0, copyArr2, 0, arr.length);
			System.out.println("변경 전");
			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(copyArr1));
			System.out.println(Arrays.toString(copyArr2));
			
			arr[0] = 1;
			copyArr1[0] = 999;
			copyArr2[0] = 6789;
			
			System.out.println("변경 후");
			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(copyArr1));
			System.out.println(Arrays.toString(copyArr2));
			
			
		}










}
	
			
			
		







