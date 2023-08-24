package edu.kh.thread.ex1;

// 스레드 생성 방법 2 : Runnable 인터페이스
// 장점 : run() 메서드 오버라이딩이 강제 됨.
// 단점 : 해당 스레드를 생성 시키는 방법 
public class TestThread2 implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "실행");
		
		for(int i = 0; i<10 ; i++) {
			System.out.println("1번 스레드 " + i);
		}
		
		
	}

}
