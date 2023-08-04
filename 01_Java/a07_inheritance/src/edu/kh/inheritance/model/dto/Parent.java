package edu.kh.inheritance.model.dto;
							// 모든 클래스
public class Parent extends Object {

	private int money = 100_000_000; 
	private String lastName = "홍";
	
	public Parent() {
		System.out.println("Parent() 기본 생성자로 부모 객체 생성");
		
	}
	
	public Parent(int money, String lastName) {
		System.out.print("Parent(int, String) 매개변수 생성자로 부모 객체 생성");
		
		this.money = money;
		this.lastName = lastName;
	
	}   
	public int getMoney() {
		return money;
	
	}
	
	public void setMoney(int money) {
		this.money = money;
		
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastNAme) {
		this.lastName = lastName;
	}
	
	public String toString() {
		return money + " / " + lastName;
	// 오브젝트의 toString() 오버라이딩 
	}
	
	
}
