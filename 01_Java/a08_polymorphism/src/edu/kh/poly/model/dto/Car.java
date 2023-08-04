package edu.kh.poly.model.dto;

public class Car extends Object {
	
	private int wheel; // 바퀴 개수
	private int seat;
	private String fuel;
	
	// 기본생성자 자동완성 :  ctrl + space bar -> enter
	public Car() {
	// TODO Auto-generated constructor stub 
	}

	// 매개변수 자동완성 : alt + shift + s o
	public Car(int wheel, int seat, String fuel) {
		super();
		this.wheel = wheel;
		this.seat = seat;
		this.fuel = fuel;
	}

	// getter, setter 자동 완성 : alt shift s -> r
	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	// toString() 오버라이딩 자동 완성
	// alt shift s -> s
	
	@Override
	public String toString() {
		return "Car [wheel=" + wheel + ", seat=" + seat + ", fuel=" + fuel + "]";
	}

	
	
	
	
	
}
