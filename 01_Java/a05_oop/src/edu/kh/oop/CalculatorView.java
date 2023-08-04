package edu.kh.oop;

import java.util.Scanner;

public class CalculatorView {
	
	private Calculator calc = new Calculator();
	private Scanner sc = new Scanner(System.in);

	public void displayMenu() {
		
		//계산기 메뉴 표시 기능
		int input = 0; // 메뉴 저장용 변수
		
		do {
			System.out.println("------------------------------");
			System.out.print("현재 값 : " + calc.getSaveValue());
			System.out.println("\n------------------------------");
			
			System.out.println("1. 더하기(+)");
			System.out.println("2. 빼기(-)");
			System.out.println("3. 곱하기(*)");
			System.out.println("4. 나누기(/)");
			System.out.println("5. 초기화");
			System.out.println("6. 최대값으로 변경");
			System.out.println("7. 최소값으로 변경");
			System.out.println("8. 원의 넓이 구하기");
			
			System.out.println("0. 종료 \n");
			
			System.out.print("메뉴 선택 : ");
			input = sc.nextInt();
			
			switch(input) {
			case 1 : System.out.println( plus() );     
			break;   // 같은 클래스의 다른 메서드 호출할 때는 메서드 이름만 작성해도 된다.
			
			case 2 : System.out.println( minus() );		
			break;
			
			case 3 : System.out.println( multi() );
			break;
			
			case 4 : System.out.println( div() );
			break;
			
			case 5 : System.out.println("초기화 : " + calc.init() );
			break;
			
			case 6 : System.out.println("최대값으로 변경 : " + calc.changeMaxValue() );
			break;
			
			case 7 : System.out.println("최소값으로 변경 : " + calc.changeMinValue() );
			break;

			case 8 : System.out.println( ofCircle() );
			break;
			
			case 0 : System.out.println("종료");
			break;
			
			default : System.out.println("오류");
			
			}
			
		} while(input != 0);
		
	}  // displayMenu() 끝 // ctrl + p {   } 시작/ 끝 지점 이동
	
	private String plus() {
		
		System.out.print("더하고 싶은 값을 입력하세요.\n: ");
		double number = sc.nextDouble();
		
		double saveValue = calc.getSaveValue();
		double result = calc.plus(number);
		
		//String.format()
		String str = String.format("%.2f + %.2f = %.2f \n", saveValue, number, result);
		return str;
	}
	
	private String minus() {
		
		System.out.println("빼고 싶은 값을 입력하세요. \n");
		double number = sc.nextDouble();
		
		double saveValue = calc.getSaveValue();
		double result = calc.minus(number);
		
		String str = String.format("%.2f - %.2f = %.2f \n", saveValue, number, result);
		return str;
	}
	
	private String multi() {
		
		System.out.println("곱하고 싶은 값을 입력하세요. \n");
		double number = sc.nextDouble();
		
		double saveValue = calc.getSaveValue();
		double result = calc.multi(number);
		
		String str = String.format("%.2f * %.2f = %.2f \n", saveValue, number, result);
		return str;
	}
	
	private String div() {
		
		System.out.println("나누고 싶은 값을 입력하세요. \n");
		double number = sc.nextDouble();
		
		double saveValue = calc.getSaveValue();
		double result = calc.div(number);
		
		String str = String.format("%.2f / %.2f = %.2f \n", saveValue, number, result);
		return str;
	}
	
	private String ofCircle() {
		
		System.out.print("반지름 입력 : ");
		double r = sc.nextDouble();
		
		String str = String.format("PI * %.2f^2 = %.2f \n", r, calc.ofCircle(r) );
		return str;
	
	}
	
	
}
