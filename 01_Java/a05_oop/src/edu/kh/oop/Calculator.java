package edu.kh.oop;

public class Calculator {
	
	private final double PI = 3.141592;
	private final int MAX_VALUE = 1_000_000_000;
	private final int MIN_VALUE = -1_000_000_000;
	
	private double saveValue; // 
	
	// 기본 생성자
	
	public Calculator() {}
	// saveValue의 setter 
	public void setSaveValue(double saveValue) {
		this.saveValue = saveValue;
		
	}
	// saveValue의 getter 
	public double getSaveValue() {
		return saveValue;		
	}	
	
	public double plus(double number) { 
		saveValue += number;
		return saveValue;	
	}	
	
	public double minus(double number) {
		saveValue -= number;
		return saveValue;	
	}
	
	public double multi(double number) {
		saveValue *= number;
		return saveValue;
	}
	
	public double div(double number) {
		if(number == 0) { // 전달 받은 값이 0일 경우
			saveValue = 0;
			return saveValue;
			// 0인 경우 saveValue를 0으로 만든 후 
			// 0 return 후 매서드 종료
		}
		saveValue /= number; 
		return saveValue;
			// 0이 아닌 경우
			// saveValue/number return 후 매서드 종료
	
	}
	
	public double init() {
		saveValue = 0;
		return saveValue;
	}
	
	public double changeMaxValue() {
		saveValue = MAX_VALUE;
		return saveValue;
	
	}
	
	public double changeMinValue() {
		saveValue = MIN_VALUE;
		return saveValue;
		
	}
	
	public double ofCircle(double r) {
		saveValue = PI * r * r;
		return saveValue;
		
	}
	
	
}
