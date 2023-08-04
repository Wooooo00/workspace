package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx1 {

	public static void main(String[] args) { 
		// 산술 연산자 
		// + - * / %(modulo, mod, 나머지 연산)
		
		// 두 수를 입력 받아 
		// + - * / % 연산 결과를 모두 출력
		
		// [예시]
		// 정수 입력 1 : 5 
		// 정수 입력 2 : 2
		
		// 5 + 2 = 7
		// 5 - 2 = 3
		// 5 * 2 = 10
		// 5 / 2 = 2.5
		// 5 % 2 = 1
		
		// 스캐너 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 1 : ");
		int input1 = sc.nextInt();
		
		System.out.print("정수 입력 2 : ");
		int input2 = sc.nextInt();
		
		System.out.println(); // 줄바꿈 (개행)
		
		// + 연산
		
		System.out.println( input1 + " + " + input2 + " = " + (input1 + input2)   );
		
		int minusResult = input1 - input2;
		
		System.out.println(input1 + " - " + input2 + " = " + minusResult);
		
		// 연산 * (printf 사용) 
		
		// %d : 10진수 정수가 들어오는 칸
		
		//System.out.printf("빈칸이 포함된 문자열" , 빈칸에 들어갈 값 );
		System.out.printf("%d * %d = %d ", input1, input2, input1 * input2);
		System.out.println();
		
		// %d : 10진 정수가 들어오는 칸
		// %f : 10진 실수가 들어오는 칸
	
	
		// / 연산
		System.out.printf("%d / %d = %.1f", input1, input2, (double)input1/ input2);
		
		
		
		// 5/2의 결과가 2.5가 아닌 2인 이유는 
		// 컴퓨터의 값처리 원칙에 의해서 
		// int / int의 결과는 int형이 된다
		// 그러므로 5/2의 결과는 (int) 2.5의 결과 2가 된다. 
		// 그렇다면 5/2의 결과가 2.5가 나오게 하려면 어떻게 해야할까 
		// input1 또는 input2를 (double)로 강제 형변환하면 된다
		// (double)input1 / input2
		// double/ int -> double/double
		
	

		// % (나머지) 연산 -> 몫이 정수로 다 나눠진 후 나머지가 출력
		System.out.println();
	    System.out.printf("%d %% %d = %d" , input1, input2, input1 % input2); 
	    //  %% -> printf에서 문자열 "%"를 의미하는 기호 
	    
	}
}
