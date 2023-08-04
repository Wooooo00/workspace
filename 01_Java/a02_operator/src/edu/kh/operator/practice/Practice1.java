package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in);
    
    System.out.println("[실행화면]");
    
    System.out.print("인원 수 : ");
    int input1 = sc.nextInt();
    
   
    System.out.print("사탕 개수 : ");
    int input2 = sc.nextInt();
    
    
    System.out.println(); 
    
    
    System.out.println("1인당 사탕 개수 : "); 
    System.out.println("남은 사탕 개수 : " );
    
    
    
    
    
    // 1인당 개수 -> 몫 남는 사탕 -> 나머지 
	
	
    //========================================
    
System.out.println("[실행화면]");
    
    System.out.print("인원 수 : ");
    int count = sc.nextInt();
    
    System.out.print("사탕 개수 : ");
    int candy = sc.nextInt();
    
    System.out.printf("1인당 사탕 개수 : %d \n ", candy/count);
    
    System.out.printf("남는 개수 : %d \n ", candy%count);
    
    
    
    
   
	
	}

}
