package edu.kh.thread.ex2;

public class ThreadControlRun {
	public static void main(String[] args) {
		
		Thread sleepTest = new Thread( new SleepThread1() );
		//sleepTest.start();
		
		// 시계
		Thread clockThread = new Thread( new MyClock() );
	//	clockThread.start();
		
		Thread test = new Thread(new SleepThread2() );
	//	test.start();
		
		InterruptTest it = new InterruptTest();
	//	it.test();
		
		StopWatchController controller = new StopWatchController();
		controller.watchStart();
		
		
		
		
	}

}
