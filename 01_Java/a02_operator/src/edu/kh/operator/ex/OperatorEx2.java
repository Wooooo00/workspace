package edu.kh.operator.ex;
// main 작성 후 ctrl + spacebar(자동완성) -> main 선택 
// syso , sysout -> ctrl + spacebar -> enter 

public class OperatorEx2 {
	public static void main(String[] args) { 
   
// 증감 연산자 : ++ / -- 피연산자를 1씩 증가 or 감소 시키는 연산자 
	
System.out.println("[전위 연산]");		

System.out.println("증가 연산 테스트");
int num1 = 5;

System.out.println(num1);
System.out.println(++num1);
System.out.println(++num1);
System.out.println(++num1);
System.out.println(++num1);

System.out.println("감소 연산 테스트");
int num2 = 10;
System.out.println(num2);
System.out.println(--num2);
System.out.println(--num2);
System.out.println(--num2);
System.out.println(--num2);


System.out.println("--------------");
System.out.println("[후위 연산]");
// ** 후위 연산은 우선 순위가 제일 마지막이다! **

System.out.println("증가 연산 테스트");
int num3 = 20;
System.out.println(num3);
System.out.println(num3++); // 20이 출력되고 21로 증가한다.
System.out.println(num3++);
System.out.println(num3++);
System.out.println(num3);

System.out.println("감소 연산 테스트");
int num4 = 99;
System.out.println(num4--); 
System.out.println(num4--);
System.out.println(num4--);
System.out.println(num4--);
System.out.println(num4);

// ------------------------------------

//연습 문제 
int a = 3;
int b = 5;
int c = a++ + --b;
// 최종적으로 a, b, c는 각각 얼마? 

System.out.printf("a = %d, b = %d, c = %d" , a, b, c);




		
		
	}

}
