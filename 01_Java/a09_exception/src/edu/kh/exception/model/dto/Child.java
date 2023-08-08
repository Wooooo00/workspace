package edu.kh.exception.model.dto;


import java.io.EOFException;
import java.io.IOException;
import java.net.SocketException;
import java.util.zip.DataFormatException;

public class Child extends Parent {
	
	// 클래스 사이의 상속 : extends
	// 인터페이스 사이의 상속 : implements

	// 상속 부모의 멤버를 자식이 자신의 것처럼 사용
	
	// 오버라이딩 : 상속 받은 부모의 메서드를 자식이 재정의하는 것 
	
//	@Override
//	public void method() throws IOException {}

	// 예외의 범위를 좁게(자식 예외)를 쓰면
	
//	@Override
//	public void method() throws EOFException {}
	
//	@Override
//	public void method() throws Exception {}
	// 예외의 범위를 넓게(부모 예외)를 쓰면 문제 발생(불가능)
	
// 예외의 개수를 다르게 쓰는 경우
	@Override
	//public void method() throws IOException, DataFormatException {} 불가함
	public void method() throws EOFException, SocketException {} // 가능
}
	

