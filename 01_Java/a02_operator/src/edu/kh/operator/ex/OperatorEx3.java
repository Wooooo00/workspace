package edu.kh.operator.ex;

public class OperatorEx3 {
	public static void main(String[] args) {
    // 비교 연산자 : > < >= <= ==(같다) !(같지 않다)
    //          초과, 미만, 이상, 이하, 같다, 같지 않다

		// 복합 기호에서 등호(=)는 항상 오른쪽 * 
		// 비교 연산의 결과는 논리값 (true/false) * 
		
		int a = 100;
	    int b = 200;
	    
	    System.out.println(a != b); 
	    System.out.println(a > b); 
	    System.out.println(a < b); 
	    System.out.println(a < b - 100); 
	    System.out.println(b <= a + a); 
	    System.out.println(a < b == true); 
	    
	    System.out.println("--------------------------------");
	    
	    System.out.println("[짝수 검사]");
	    // 짝수 == 2로 나누었을 때 나머지가 0인 수 
	    //        2로 나누었을 때 나머지가 1이 아닌 수
	    // %b : 논리형 출력을 위한 칸 
	    // \n : 개행문자 (줄을 바꾸는 문자 == 엔터 역할)
	    System.out.printf("3은 짝수? %b \n", 3 % 2 == 0);
	    System.out.printf("4은 짝수? %b \n", 4 % 2 == 0);
	   
	    System.out.printf("6은 짝수? %b \n", 6 % 2 != 1);
	    
	    System.out.println("\n[홀수 검사]");
	    // 홀수 == 2로 나누었을 때 나머지가 1인 수 
	    //        2로 나누었을 때 나머지가 0이 아닌 수

	   System.out.printf("12345는 홀수? %b \n", 12345 % 2 == 1);
	   System.out.printf("432는 홀수? %b \n", 12345 % 2 == 1);
	   
	   
	   System.out.println("[3의 배수 검사]");
	   
	   System.out.printf("1234123은 3의 배수? %b \n", 1234123 % 3 == 0);
	   System.out.printf("324234236은 3의 배수? %b \n", 324234236 % 3 == 0);
	   System.out.printf("936은 3의 배수? %b \n", 936 % 3 == 0);
	   
	   
	   System.out.println("\n[13의 배수 검사]"); 
	   
	   System.out.printf("169는 13의 배수? %b \n", 169 % 13 == 0); 
	   System.out.printf("4613은 13의 배수? %b \n", 4613 % 13 == 0);  
	     
	  
	    
	    
	    
	  
	
	
	
	
	
	
	}


}
