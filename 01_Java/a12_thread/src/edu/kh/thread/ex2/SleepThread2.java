package edu.kh.thread.ex2;

public class SleepThread2 implements Runnable {

	@Override
	public void run() {
		
		int count = 0;
		
		while( !Thread.currentThread().isInterrupted() ) {
			
			try {
				Thread.sleep(500);
				
				System.out.println( ++count );
			
			} catch (InterruptedException e) {			
				e.printStackTrace();
				System.out.println(" === 인터럽트에 의해 종료 === ");
				
				// sleep() 중 interrupt() 메서드가 호출되면
				// InterruptedException이 발생하면
				// interrupted 필드값이 true로 바뀌지 않는다
				// catch문에서 interrupted 필드값을 true로 변경
				Thread.currentThread().interrupt();
			
			} 
			
			
			
		}
		
	}
	

}
