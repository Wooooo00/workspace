package edu.kh.thread.ex2;

public class StopWatch implements Runnable {

	@Override
	public void run() {
		
		int count = 0;
		
		int min = 0;
		int sec = 0;
		int hour = 0;
		
		while( !Thread.currentThread().isInterrupted() ) {
			
			try {
				Thread.sleep(9);
				count++; // 0.01초 마다 카운트 증가
				
				if(count == 100) { // 1초가 됐을 때 초를 1 증가
					sec++;
					count = 0;										
				} 
				
				if(sec == 60) {
					min++;
					sec = 0;
				}
				
				if(min == 60) {
					hour++;
					min = 0;
					
				}
				
				System.out.printf("%d시 %d분 %d초 %d \n", hour, min, sec, count);
				
			
			} catch (InterruptedException e) {			
				e.printStackTrace();
				System.out.println(" === 인터럽트에 의해 종료 === ");
				
				
				Thread.currentThread().interrupt();
			
			} 
			
			
			
		}
		
	}
	

}
