package a05.oop.basic;

// 국민 정보를 저장할 객체를 위한 클래스(설계도)
public class Nation {
	
	// 속성
	private String pNo;
	private String name;
	String address;
	String phone;
	char gender;
	int age;
	
	// 캡슐화 적용 : 불투명화해서 가리기(외부로부터의 직접 접근을 차단해서 존재 유무, 
	//							  실제 데이터를 모르게 하기(정보 은닉)  
	private String job; 
	
	// private -> 현재 클래스 안에서만 접근 가능 
	
	// 기능
	public void speakKorean() {
		System.out.println("한국어 사용");
		
	}
	
	public void 납세() {
		System.out.println("세금");
	}
	
	public void introduce() {
		
		System.out.printf("저의 이름은 %s이고, 직업은 %s입니다. \n" , getName(), job);
		
		// 자기 소개 기능
		
	}
		
	// 캡슐화 원칙에 의해서 
	// 직접 접근이 차단된 변수(필드)에 값을 세팅하거나 얻어갈 수 있는 간접 접근 기능을 작성
	
	// 전달 받은 값으로 job을 세팅하는 기능
	public void setJob(String job) { // String job (매개변수)
		this.job = job;				// 전달된 값을 저장하는 변수 
		
		
	}
	
	// Nation 객체가 가지고 있는 job의 값을 호출한 곳으로 돌려보내주는 기능
	public String getJob() { 
		return job;
		
	}

	public void 납세의의무() {
		// TODO Auto-generated method stub
		
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// public //
	// default // 같은 패키지 안에서만 사용 가능한 클래스
	
}

	
