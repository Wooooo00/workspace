package edu.kh.thread.ex3;

import edu.kh.thread.ex2.MoveStar;

public class MoveRun {
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new MoveHeart() );
		Thread th2 = new Thread(new MoveStar() );
		
		try {
			th1.start();
			Thread.sleep(500);
	
			th2.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
