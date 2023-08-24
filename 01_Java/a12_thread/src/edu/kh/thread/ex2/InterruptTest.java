package edu.kh.thread.ex2;

import java.util.Scanner;

public class InterruptTest {
	
	/* interrupt란? 
	 * -> 스레드의 동작을 방해하여 멈추게 한다.
	 * void interrupt() 
	 * 현재 스레드의 interrupted 필드값을 true로 변경
	 * interrupted 필드 == false -> 작업 진행
	 * interrupted 필드 == true -> 작업 중단
	 * @주의사항@ Thread.sleep()에 의해 일시정지된 스레드에 
	 * interrupt()를 호출하게 되면
	 * 스레드의 interrupted 필드값이 true로 변하지 않고 (작업이 중단되지 않음)
	 * InterruptedException이 발생한다.
	 * 
	 * boolean isInterrupted()
	 * 현재 스레드의 interrupted 필드값을 반환(getter)
	 * 
	 * 
	 * boolean Thread.interrupted()
	 * 현재 스레드의 interrupted 필드값을 반환
	 *  +false로 값을 변경
	 */

	public void test() {
		Thread sleep2 = new Thread( new SleepThread2() );
		sleep2.start();
		
		System.out.println("<엔터 입력 시 종료>");
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine(); // 입력 버퍼에서 다음 \n까지 읽어오기
					   // 단, 버퍼가 비어 있으면 다음 \n(입력 시까지 현재 스레드 무한 대기)
		
		// 엔터 입력 시 
		sleep2.interrupt();
		
		System.out.println("<프로그램 종료>");
		
		
	}		
	
	
	
	
	
	
	
	
}
