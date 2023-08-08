package edu.kh.poly.model.dto;

public class LCWCalculator implements Calculator {

	public int plus(int a, int b) {
		return a + b;
		
	}
	
	public int minus(int a, int b) {
		return a - b;
	
	}

	public int multi(int a, int b) {
		return a * b;
	}

	@Override
	public int div(int a, int b) {
		return a / b;
	}

	@Override
	public int mod(int a, int b) {
		// TODO Auto-generated method stub
		return a % b;
	}

	@Override
	public double areaOfCircle(double r) {
		// TODO Auto-generated method stub
		return PI * r * r;
	}
	
	// 재귀 호출
	public int pow(int a, int x) {
		return x == 1 ? a : a * pow(a, x-1);
	}
 	
	// extends는 클래스끼리의 상속 or 인터페이스끼리의 상속
	// implements : 부모 인터페이스 자식 클래스 상속
	// 			  : 인터페이스는 다중 상속 가능
	// 부모 인터페이스 - 
	
	
	

}
