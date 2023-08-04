package edu.kh.control.loop.ex;

import java.util.Scanner;

public class LoopEx2 {
	
	
	public void ex1() {
		
		System.out.println("구구단 2단 출력하기");
		for(int i=1 ; i<=9 ; i++) {
			System.out.printf("2 X %d = %d \n", i, 2*i);
		}
		
	}
	
	// 2
	// 입력 받은 수 
	// 변수 * 1~9 = 결과
	// [숫자를 입력하세요]
	
	public void ex2() { 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		
		System.out.printf("\n[구구단 %d단]\n", dan);
		
		for(int i=1 ; i<=9 ; i++) {
			System.out.printf("%d x %d = %d \n",dan, i, dan*i);
			
		}
		
		
		
	}
	
	
	
	
	
	
	// 3
	// 입력 받은 단 출력하기
	// 조건 : 입력 받은 값이 2~9 사이일 때만 구구단 출력
	// 2~9 범위를 벗어나는 경우 "잘못 입력" 출력
	
	// 단 입력
	// if 2~9 
	// else 잘못 입력 
	
	public void ex3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력: ");
		int dan = sc.nextInt();
		
		if(dan <= 2 && dan <=9) {
			
			System.out.printf("\n[구구단 %d단]\n", dan);
		
			for(int i=1 ; i<=9 ; i++) {
				System.out.printf("%d x %d = %d \n",dan, i, dan*i);
			} 
		}
	    else {
			System.out.print("잘못 입력"); 
		}
		
	}
			
	// 4) 54321 출력 
	// i = 5 i >=1 i-- 
	public void ex4() {
		
		for(int i=5 ; i >=1 ; i--) {
			System.out.printf("%d ", i);
			
		}
		
		System.out.println();
		
	}
	
	// 5) 
	// 987654까지 출력 
	public void ex5() { 
		
		for(int i=9 ; i >= 4 ; i--) {
			System.out.printf("%d ", i);
		}
		
		System.out.println();
		
		}

	// 중첩 반복문
	// for문 안에 for문이 있는 경우 
	// ex) 0~59초 -> 1분 0~59초 1분 = 60초 
	
	
	// 12345
	// 12345
	// 12345 
	public void ex6() {
		// 5회 반복
		for(int x=1 ; x<=5 ; x++) {
			
			for(int i=1 ; i<=5 ; i++) {
				System.out.print(i);
			}
			
			System.out.println(); // 12345 출력 후 줄바꾸는 역할
			
		}
		
	}
	
	// 7)
	// 54321 줄 바꿔서 4번 출력
	public void ex7() {
		
	   for(int x=1 ; x<=4 ; x++) {
	// for(int x=4 ; x>=1 ; x--) {
			for(int i=5 ; i>=1 ; i--) {
				System.out.print(i);
			}
			
			System.out.println();
		}
		
	}
	
	// 8) 
	// 좌표 찍기 (x,y)
	// ( , ) ( , ) ( , )
	public void ex8() {
			
		   for(int x=0 ; x<=1 ; x++) { 
			   
		   
			// 괄호 두번 째 
			for(int i=0 ; i<=2 ; i++) {
				
				System.out.printf("(%d,%d) ", x, i);
			}
			System.out.println(); // 개행
		  }
	 }
	
	// 9) 
	// 2단부터 9단까지 모두 출력하기
	
	public void ex9() {
		
		for(int x=2 ; x<=9 ; x++) {
			
		    for(int i=1 ; i<=9 ; i++) {
				System.out.printf("%d x %d = %d \n", x, i, x * i);
				
				
			}
		    	System.out.println();
		
		}
		
	}
	
	// 10) 구구단 거꾸로 출력하기
	
	public void ex10() {
		
		for(int dan=9 ; dan>=2 ; dan--) {
			
			System.out.printf("[%d단] \n",dan);
			
			// 곱해지는 수
			for(int i=1 ; i<=9 ; i++) { 
				System.out.printf("%d x %d = %d \n", dan, i, dan * i );
			
		  }
			System.out.println("----------");
			
		}
			
	}
	
	// 11) 구구단 출력
	// 조건) 1입력 시 2~9 순서로 출력
	//  	2입력 시 9~2 순서로 출력
	//		1,2가 아니면 "잘못 입력하셨습니다" 출력
	
	
	public void ex11() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[1]이나[2]를 입력하세요.");
		int input = sc.nextInt();
		
		
		if(input == 1) {
			for(int dan = 2 ; dan<=9 ; dan++) {
				for(int i=1 ; i<=9 ; i++) { 
					System.out.printf("%d x %d = %d \n", dan, i, dan * i );
					
				 }
				
				
			}
		}else if (input ==2) {
			for(int dan = 2 ; dan<=9 ; dan++) {
				for(int i=9 ; i>=9 ; i--) { 
					System.out.printf("%d x %d = %d \n", dan, i, dan * i );
				}
				
			}
			
		}
			
		else {
		 System.out.println("잘못 입력");
		}
		
	} 

			
		

	
	// switch(input) { 
	// case 1 :
	// for }


	// 12) count 변수 이용하기 

	public void ex12() {
		
		int count = 0; // 안쪽 for문이 반복할 때마다 1씩 카운트
		
		// 행 줄
		for(int row = 1 ; row <=3 ; row ++) {
			// 열 칸
			for(int column = 1 ; column <= 3 ; column++) {
				
				count++;
				System.out.print(count + " ");
			
			}
			
			System.out.println(); // 개행
		
		}
		
	}
		
	
	
	
	






















}
	
	
	
	
	
	