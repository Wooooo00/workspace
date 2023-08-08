package edu.kh.poly.model.dto;

public class CalculatorRun {

	public static void main(String[] args) {
		
		// 인터페이스는 객체 생성이 가능할까
		// Calculator calc = new Calculator(); -> 불가
		
		// 인터페이스는 부모 참조 변수가 될 수 있을까?
		// (다형성)
		
		// Calculator calc = new LCWCalculator();
		Calculator calc = new LCWCalculatorV2();
	
		// 동적 바인딩 확인
		
		System.out.println( calc.plus(10, 5) );
		System.out.println( calc.minus(20, 30) );
		System.out.println( calc.multi(8 , 9) );
		System.out.println( calc.div(5, 3) );
		System.out.println( calc.mod(5, 3) );
		System.out.println( calc.areaOfCircle(2.5) );
		System.out.println( calc.pow(2, 3));
	}
}
