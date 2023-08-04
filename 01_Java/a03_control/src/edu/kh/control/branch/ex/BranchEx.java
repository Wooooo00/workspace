package edu.kh.control.branch.ex;

import java.util.Scanner;

public class BranchEx {
	
	// 분기문
	// break : (가장 가까운) 반복문을 멈춤
	// continue : (가장 가까운) 반복문의 시작 부분으로 이동(다음 반복으로 진행) 
	
	public void ex1() { 
		
		for(int i=1 ; i<=10000 ; i++) { 
			System.out.println(i);
			
			if(i % 2 == 1) {
				continue;
			}
		
			
			if(i==20) { // i==20인 경우에 반복을 멈춤 
				break;
			
			
			}
		
				
		}
		
}
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0; // 합계
		
		// 방법1) while문
		// 방법2) do-while문
		// 방법3) while + break
		
//		int input =  -1;
		
// 방법1		while(input !=0) { // 0이 아닐 때 반복하는 조건
//			System.out.print("입력 : ");
//			input = sc.nextInt();
//			sum += input;	
//		}
		
//		int input;
//		
//		do {
//			System.out.print("입력 : ");
//			input = sc.nextInt();
//			sum += input;
//			
//	}
		
		while(true) {  // 무한 반복 
			System.out.print("입력 : ");
			int input = sc.nextInt();
			if(input == 0) { // 0을 입력하면 반복문 종료
				break; 
			}
			sum += input;
		}
		//  Unreachable code 
		System.out.println("합계 : " + sum);
		
	}
	
		// 중첩 반복문에서 분기문 동작 확인
		public void ex3() { 
			
			for(int row = 1 ; row <= 5 ; row++) {
				
				for(int col = 1 ; col <=9 ; col++) {
					// col이 3의 배수인 경우는 출력 X 
					if(col % 3 == 0) {
						continue; // 다음 반복 수행
					}
					System.out.printf("(%d, %d) ", row, col);
					
				}
				System.out.println();
				// row가 3일 때 반복을 종료
				if(row == 3) {
					break; // break를 감싸고 있는 row 제어 for문이 멈춤
				}
			}
	
		}
	
		public void upDownGame() {
			
			// 1 ~ 100까지 난수를 하나 생성하여 
			// 사용자가 이를 맞히는데 걸리는 횟수를 카운트
			// 틀린 경우 입력한 값이 난수보다 큰지, 작은지 출력 
			
			Scanner sc = new Scanner(System.in);
			// Math.random() : 0.0 이상 1.0 미만의 난수를 반환한다.
			int answer = (int)(Math.random() * 100 + 1); // 1~100
			
			//System.out.println(answer); // 임시로 답을 확인
			
			int count = 1; // 시도한 수 저장용 변수
			
			while(true) { // 언제 끝나는지 모르니까 일단 무한으로 반복
				System.out.print(count + "번 입력 : ");
				int input = sc.nextInt();
				
				// 잘못 입력한 경우
				if(input < 1 || input > 100) { 
					System.out.println("<1~100 사이의 수를 입력하세요> \n");
					continue;
				}
				
				if(input < answer) {
					// 생성한 변수보다 입력값이 작은 경우
					System.out.println("UP");
		
				} else if(input > answer) {
					System.out.println("Down");
			
				} else { // 같은 경우
					System.out.println("정답!");
					System.out.printf("총 입력 횟수 : %d회", count);
		
					break; // while문 반복 종료
				}
				count++;
			}
			
		}
	
	
	
	
	
	
	}
