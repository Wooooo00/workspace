package edu.kh.exception.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

import edu.kh.exception.model.dto.UserException;

public class ExceptionService {

	// ==========================================================================================
	
	public void ex1() {
		
		// Checked Exception 확인
		
		// 예외 처리 구문 (try-catch)
		
		// BufferReader : 빨리 읽어오는 객체
		BufferedReader br 
		= new BufferedReader( new InputStreamReader(System.in) );
	// 키보드 입력을 효율적으로 읽어오는 객체
		// Scanner보다 기능은 부족하지만 속도가 매우 빠름
		
		System.out.print("문자열 입력 : ");
		
		try {			
			String input = br.readLine(); // 한 줄 읽어오기 
		
			System.out.println("입력 받은 문자열 : " + input);
		}	catch(IOException e) {
			// catch : try 구문에서 던져진 예외의 객체를 잡는 구문
			System.out.println("예외 처리");
		}
		
		
		// br.readLine()을 작성하면 빨간줄이 뜬다
		// 왜? 
	    // 문제가 발생할 가능성이 높아서 꼭 대비하라
		
		
	
	}
	
	// ==================================================================================
	
	// public : 어디서든 접근(호출) 가능
	// void : 반환형이 없는 메서드
	// () : 매개변수(전달 받을 값이) 없음
	
	public void ex2() {
		
		Scanner sc = new Scanner(System.in);
		
		
		// 숫자 2가 0인 경우
		// "0"으로 나눌 수 없습니다" 출력 후 메서드 종료
//		if(input2 == 0) {
//			System.out.println("0으로 나눌 수 없습니다.");
//			return;
//		}
		
		
		
		try { 
			
			System.out.print("숫자 1 : ");
			int input1 = sc.nextInt();
			// InputMismatchException 발생 가능성이 있다.
			// (Unchecked Exception) 
			
			System.out.print("숫자 2 : ");
			int input2 = sc.nextInt();
			
			
			System.out.printf("%d / %d = %d", input1, input2, input1/input2);
			// System.out.println(input1 / input2);
			
		}	catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
	
		}	catch(InputMismatchException e) { // catch는 연달아서 작성 가능
			System.out.println("잘못 입력.");
		}
		
		
		// Unchecked Exception
		// -> 예외 처리가 강제되지 않는 예외
		// 개발자, 사용자의 단순 입력 실수로 인해 일어나는 경우가 많다.
		
		
		
	}
		
	// =========================================================================================
		public void ex3() {
			
		Scanner sc = new Scanner(System.in);	
		
		try {
			
			
		System.out.print("숫자 1 : ");
		int input1 = sc.nextInt();
		
		
		System.out.print("숫자 2 : ");
		int input2 = sc.nextInt();
		
		
		System.out.printf("%d / %d = %d", input1, input2, input1/input2);
		
		
	}	catch(RuntimeException e) {
		System.out.println("예외 발생.");
		// RuntimeException은 
		// ArithmeticException, InputMismatchException 의 부모
		// 부모 타입 예외 참조 변수로 
		// 자식 타입 예외 객체를 참조한다 == 다형성 업캐스팅
		// 따라서 부모 타입으로 모든 자식 예외를 잡아서 처리 가능
	}	
		
		
		
	}
	// ==========================================================================================
		
		public void ex4() {
			
			Scanner sc = new Scanner(System.in);	
			
			try {
				
				
			System.out.print("숫자 1 : ");
			int input1 = sc.nextInt();
			
			
			System.out.print("숫자 2 : ");
			int input2 = sc.nextInt();
			
			
			System.out.printf("%d / %d = %d", input1, input2, input1/input2);
			
			
		}	catch(InputMismatchException e) {
			System.out.println("잘못 입력");
			// catch 문 여러 개 작성할 때
			// 자식 타입 처리 코드가
			// 부모 타입 처리 코드보다
			// 먼저 작성 되어야 한다. 
		}	catch(RuntimeException e) { // 부모 타입
			System.out.println("예외 발생.");
			
		}	//catch(InputMismatchException e) {
			// RuntimeException(부모 타입)이 
			// InputMismatchException까지 먼저 잡아서 처리하기 때문에 
			// 현재 catch문이 실행 되는 경우가 절대 없다.
			//	}
		
		}	
		
		// =========================================================================================
		
		public void ex5() {
			// try : 예외가 발생할 것 같은 구문을 실행(시도)
			// catch : try에서 발생한 예외를 잡아서 처리
			// finally : 예외 처리가 되든 말든 무조건 실행
			
			// 강제 예외 발생 : throw new 예외 클래스명();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("1. 정상 동작 / 2. 예외 강제 발생 \n입력 : ");
			int input = sc.nextInt();
			
			try {
				switch(input) {
				case 1 : System.out.println("정상 동작");
				break;
				
				case 2 : throw new Exception("<강제 발생>");
				default : System.out.println("잘못 입력");
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
				
			} finally {
				System.out.println(" ===== 무조건 실행 ===== ");
			}
			
			}
				
	// =============================================================================================
		
			public void ex6() {
			
			Scanner sc = new Scanner(System.in);
			try {
				System.out.print("입력 1 :");
				int num1 = sc.nextInt();
	
				System.out.print("입력 2 :");
				int num2 = sc.nextInt();
			
				System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
		
			} catch(InputMismatchException e) {
				System.err.println("숫자만 입력");
			
			} finally {
				
				// 예외가 발생 되던 말던
				// 메모리 누수를 막기 위해 스캐너 (or 객체)를 닫아줌
				sc.close();	
		}
			
		}
		
//			에러 
//			프로그램을 비정상 종료 시키는 상황
//			
//			 예외 
//			소스코드 수정으로 해결 가능한 에러
//			
//			필수(checked Exception)
//			반드시 예외 처리 구문을 작성해야 하는 예외
//			
//			선택(Unchecked Exception) 
//			선택적으로 예외 처리 구문을 작성해도 되는 예외
//		
//			try 
//			예외가 발생할 것 같은 코드를 작성하는 구문
//			
//			Catch 
//			try에서 발생한 예외를 잡아서 처리하는 구문
			
//			catch문은 연달아 작성 가능
//			주의점 : 부모 타입 예외를 잡는 구문이 먼저 작성되면
//			다형성 업캐스팅에 의해서 자식 예외도 모두 잡아 처리하므로 
//			아래쪽에 작성된 자식 예외 처리 구문이 절대 실행 되지 않는다.
//			
//			finally 
//			try 구문에서 예외 발생 여부에 관계없이 무조건 수행하는 구문
			
//			throws
//			메서드를 발생한 예외를 호출한 곳으로 던짐
//			다형성 적용 O
//			throws 부모타입 -> 부모 타입 + 자식 타입 예외 모두 던짐
//			throws 옆에 던지려는 예외를 여러 개 작성 가능하다			
			
//			오버라이딩 시 예외 작성 방법
//			1.똑같이 작성
//			2.자식 타입의 예외(개수 관계없음) 작성하기
			
//			사용자 정의 예외 
//			자바에서 제공하는 Exception 중 알맞은 것이 없을 때 
//			사용자가 직접 만들어 사용하는 Exception
//			만드는 방법
//			1.아무 Exception 클래스 상속 받기
//			2.생성자에 super() 생성자 작성하기
		
		// ======================================================================================
			
		public void ex7() {
			// throws : 메서드에서 발생한 예외를 
			// 호출한 상위 메서드로 던지는 것(전달하는 것)
			// (책임 전가)
			// 장점 : 예외를 한 곳으로 몰아서 처리 가능하다. (코드 길이 감소)
			// 
			try {
				
				methodA();
				
			}catch(IOException e) {
				System.out.println("IOException 예외 처리 완료");
				}
			// e : 예외 객체를 참조하는 참조 변수
				Throwable e;
				e.printStackTrace(); 
			// -> 예외 발생 메서드까지의 모든 스택 메서드를 출력
			// -> 언제 어떤 걸 호출해서 예외가 발생했는지 
				System.out.println("프로그램 정상 종료");
			public void methodA() throws IOException{
				
				methodB();
			}
			
			public void methodB() throws IOException{
				
				methodC();
				
			}
			
		}
			public void methodC() throws IOException, DataFormatException {
										// 부모 타입 예외 처리
										// IOException 또는 IOException 자식 예외를 모두 던짐
										// (다형성 적용)
//				throw new IOException();
//				throw new EOFException();
//				// EoFException == IoException의 자식 
				
				throw new DataFormatException();
				// IoException과 관련 없는 예외
				// -> 별도 처리 필요 -> throws가 여러 예외를 던지게 함 
				
			}
			
			
		public void ex8() {
			ex9();
		}
		// 숫자를 입력 받아 출력하는 메서드
		// 단, 100 초과 입력하면 예외가 발생
		public void ex9() {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("숫자 입력 : ");
			int input = sc.nextInt();
			
			if(input > 100) { // 입력한 숫자가 100 초과일 때 예외 발생
				throw new UserException("100을 초과하는 " + input + "이 입력됨");
				
			}
			System.out.println("입력한 숫자 : " + input);
		}
		

		}




}
		
		

		
		
		
}
