package edu.kh.thread.ex4;

import java.util.Scanner;

public class RaceRun {

	// 하트와 별이 움직인 거리를 카운트(띄어쓰기 횟수)
	// static : 정적 메모리 영역(여기에 생성되면 클래스명, 필드명으로 어디서든 공유 가능)
	
	public static int heartCount = 0;
	public static int starCount = 0;
	
	public static void main(String[] args) {
		
		Thread th1 = new Thread( new RaceHeart() );
		Thread th2 = new Thread( new RaceStar() );
		
		Scanner sc = new Scanner(System.in);
		System.out.print("<승패 여부를 예상해보세요> : ");		
		System.out.print("1. ♥ 2. ★ 3. 무승부");
		int input = sc.nextInt();
		
		System.out.println("<배팅할 포인트를 입력하세요> : ");
		int point = sc.nextInt();
				
		int win = 0; 
		
		try {
			th1.start();
			Thread.sleep(500);
			th2.start();
			
			// Thread.join()
			// 지정된 쓰레드가(th1, th2)가 끝날 때까지 
			// 현재 스레드를 (main)를 대기 시킴
			th1.join();
			th2.join();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 하트와 별 중 누가 더 멀리 이동했는가에 따라 
		// 승패 여부를 출력
		
		System.out.println("\n ===== 결과 ===== \n");
		
		String result = null;
		
		if(heartCount > starCount) {
			result = "[♥ 승리!]";
			win = 1;		
			
		} else if ( heartCount < starCount) {
			
			result = "[★ 승리!]";
			win = 2;
			
		} else { 			
			
			result = "[무승부]";
			win = 3;
		}	
		
		System.out.println(result);
		
		if(input == win) {
			System.out.println("[예측 성공]");
			if(win == 3) {
			point *= 3;	
			
			}else {
				point *= 2;
			}
			System.out.println("포인트" + point + "를 획득 했습니다");
			
		} else {
			System.out.println("실패");
		}
	}
	
	// 콘솔창 클리어(엔터 많이 하기)
	public static void clear() {
		// StringBuffer :  불변성 문제를 해결한 객체
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < 30; i++) {
		sb.append("\n"); // 엔터 30번 누적 sb += "\n"		
		}
		System.out.println(sb.toString());
	}
	
	
	
	
	
	
	
	
	
	
}
