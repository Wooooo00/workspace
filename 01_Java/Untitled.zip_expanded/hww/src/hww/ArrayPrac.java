package hww;

import java.util.Scanner;

public class ArrayPrac {
	
	////////////////////////////////////////////////////////
	
	public void ex1() {
		
	int sum = 0;
	
	int[] bae = new int[9];	
		
	for(int i = 0 ; i < bae.length  ; i++) {
		
		bae[i] = i + 1;
		
		if(bae[i] % 2 == 0) {
			sum += bae[i];
		}
		System.out.print(bae[i]);
		
	}
		System.out.println();
		System.out.println("짝수 인덱스 합 : " + sum);
	
	}
	
	//////////////////////////////////////////////////////
	
	public void ex2() {
		
		int[] arr = new int[9];
		
		int sum = 0;
		
		for(int i = 9 ; i < 0 ; i--) {
			
			arr[i] = i - 1;
			
			if(arr[i] % 2 == 1) {
				sum += arr[i];
			} System.out.print(arr[i]);
			
		}
		System.out.println();
		System.out.println("홀수 인덱스 합 : " + sum);
	}
	
	//////////////////////////////////////////////////////
	
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수 : ");
		
		int input = sc.nextInt();		
		int[] arr = new int[input];
		
		for(int i = 0 ; i < arr.length ; i++) { 
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
	}
	
	//////////////////////////////////////////////////////
	
	public void ex4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		int[] arr = new int[5];
		
		for(int i = 0 ; i < arr.length ; i++) {
			
			System.out.print("입력 : ");
			int num = sc.nextInt();
		}
		
		System.out.print("검색값 : ");
		if(num == arr[i]) { 
		
			
		}
	}

	//////////////////////////////////////////////////////
	
	public void ex5() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.next();
		
		
	}
	
	//////////////////////////////////////////////////////
	
	public void ex6() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		
		int input = sc.nextInt();
		
		int arr[] = new int[input];
		
		for(int i = 0 ; i < arr.length ; i++) {
		
			System.out.printf("배열 %d번에 넣을 값 : ",i);
			int number = sc.nextInt();
			arr[i] = number;
		}
		
		int sum = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");
			System.out.print(" ");
			sum += arr[i];
		} 
		System.out.println(" ");
		System.out.print("총합 : " + sum);
	}
	
	
	//////////////////////////////////////////////////////	
	public void ex7() {
		
		System.out.print("주민등록번호 입력 : "); 
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		char[] arr = new char[9];
		
		for(int i = 0; i < arr.length; i++) {
			
			if(i < 8) {
				System.out.print(arr[9]);
				
				
				
			} else {
				
				System.out.println("*");
			}
		}
		
	}
	
	//////////////////////////////////////////////////////
	
}
