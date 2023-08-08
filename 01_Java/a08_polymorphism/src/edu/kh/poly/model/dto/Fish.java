package edu.kh.poly.model.dto;

public class Fish extends Animal {
	
	private int gill; // 아가미 수
	
	
	public Fish() {
		
	}
	
	public Fish(int gill) {
		super();
		this.gill = gill;
	}


	public Fish(String string, String string2, int i) {
		// TODO Auto-generated constructor stub
	}
	

	public int getGill() {
		return gill;
	}


	public void setGill(int gill) {
		this.gill = gill;
	}


	@Override
	public String toString() {
		return super.toString() + " / " + gill;
	}
	
	public void breath() {
		System.out.println("물고기 : 아가미로 호흡");
	}
	
}
