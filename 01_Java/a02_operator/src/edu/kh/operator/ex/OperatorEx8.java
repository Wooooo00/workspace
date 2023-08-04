package edu.kh.operator.ex;

public class OperatorEx8 {
	
	public static void main(String[] args) { 
		
	// 복합 대입 연산자 : += -= *= /= %=
	// 기본 변수 값에 새로 대입되는 값의 산술 연산 결과를 대입 
		
	int a = 10;
	System.out.println("a : " + a); 
	
	a += 1; // a = a + 1; 
    System.out.println("a를 1 증가 : " + a);
   
    a += 1; // a = a += 1;
    System.out.println("a를 1 증가 : " + a);
    
   
    a += 4; // a = a + 4
    System.out.println("a를 4 증가 : " + a);
    
    a -= 7; // a = a - 7
    System.out.println("a를 7 감소 : " + a);
    
    a *= 3; // a = a * 3
    System.out.println("a를 3배 증가 : " + a);
    
    a /= 6; // a = a / 6
    System.out.println("a를 6으로 나눴을 때의 몫 : " + a);
    
    a %= 2; // a = a % 2;
    System.out.println("a를 2로 나눴을 때의 나머지 : " + a);
    
    

    

    
    

    
    
	
	
	
	
	
	
	}

}
