package edu.kh.poly.model.dto;

// Car를 상속 받은 자식 클래스 
public class Porsche extends Car {
	
	private boolean openTheDoor; 
	
	public Porsche() {
		// TODO Auto-generated constructor stub
	}

	public Porsche(boolean openTheDoor) {
		super();
		this.openTheDoor = openTheDoor;
	}

	Car의 toString() 오버라이딩
	@Override
	public String toString() {
		return super.toString() + / "Porsche [openTheDoor=" + openTheDoor + "]";
	}
	
	
	
}
