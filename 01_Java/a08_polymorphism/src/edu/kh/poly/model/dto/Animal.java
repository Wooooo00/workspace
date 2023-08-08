package edu.kh.poly.model.dto;

// 추상 클래스 
// 미완성 부분(추상 메서드)이 포함된 클래스
// 미완성이다 보니까 단독 객체로는 생성이 불가능하다.

//(단, 추상 메서드가 없어도 추상 클래스로 선언 가능)
public abstract class Animal {
	
	private String type; // 종,류(양서류, 포유류, 갑각류)
	private String eatType; // 식성
	
	
	// 추상 클래스는 단독 객체로 생성은 불가하지만
	// 상속 받은 자식의 일부분으로써는 생성 가능하다
	// 미완성된 부분은 자식 객체가 오버라이딩으로 완성하기 때문에
	public Animal() {
		super(); // 오브젝트 생성자 호출		
	}  
	
	public Animal(String type, String eatType) {
		this.type = type;
		this.eatType = eatType;
	}
	
	public String getType() {
		return type;
	}
	
	public String getEatType() {
		return eatType;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setEatType(String eatType) {
		this.eatType = eatType;
		
	}

	@Override
	public String toString() {
		return "Animal [type=" + type + ", eatType=" + eatType + "]";
	}
	
	//public void breath() {
		//System.out.println("입,코로 숨쉼");
	
	
	// abstract method (추상 메서드)
	// 몸체
	// 상속 받은 자식에 따라 코드가 달라져야하기 때문
	// 자식 클래스에서 오버라이딩이 강제화 된다
	public abstract void breath();
	
}


