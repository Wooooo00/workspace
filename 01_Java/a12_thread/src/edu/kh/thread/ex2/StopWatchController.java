package edu.kh.thread.ex2;

import java.util.Scanner;

public class StopWatchController {
	
	public void watchStart() {
		Thread stopWatch = new Thread( new StopWatch() );
		
		stopWatch.start();
		
		System.out.println(" <엔터 입력 시 종료> ");
		
		Scanner sc = new Scanner(System.in);
		
		sc.nextLine();
		// 
		
		stopWatch.interrupt();
	}

}
