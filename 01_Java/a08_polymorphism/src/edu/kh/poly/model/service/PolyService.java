package edu.kh.poly.model.service;

import edu.kh.poly.model.dto.Car;
import edu.kh.poly.model.dto.Porsche;
import edu.kh.poly.model.dto.Spark;

public class PolyService {
	
	
	private Car[] arr = {
			new Porsche(4, 2, "고급 휘발유", false) , 
			new Spark(4, 2, "휘발유", 0.5) , 
			new Porsche(6, 4, "경유", true) , 
			new Spark(4, 2, "가솔린", 0.7) ,
			new Car(8, 3, "경유")
	};
	
	// Car[] arr에서 index 번째 요소를 반환
	public Car selectOne(int index) {
		
		if(index >= 0 && index < arr.length) {
			return arr[index];
			
		}
		return null; // 정상 범위가 아닐 때
		
	}
	
}
