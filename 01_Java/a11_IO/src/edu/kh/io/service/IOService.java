package edu.kh.io.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.Buffer;
import java.util.Scanner;

import edu.kh.io.model.dto.Member;

public class IOService {

	// 바이트 기반 스트림
	// InputStream, OutputStream 최상위 인터페이스
	// 1byte

	// 문자 기반 스트림
	// Reader,Writer
	// 2byte 단위로 데이터(문자)를 입/출력하는 스트림
	// 2byte 범위 문자열,문자만 저장된 파일
	// 채팅, 인터넷 요청 데이터 전달
	//

	// 바이트 기반 출력
	//
	public void byteOutput() {

		// IO 관련 코드는 IOException 발생 시킬 가능성이 높음
		FileOutputStream fos = null;

		try {
			// byte 기반 파일 출력 스트림 생성

			fos = new FileOutputStream("byte/byteTest.txt");
			// byte 폴더 내부에 byteTest.txt 파일이 있으면 출력을 위해 연결하고
			// 없으면 파일을 만들어서 연결해라

			String content = "Hello World!!!!\n" + "12345\n" + "@@@@%%%&&\n" + "재밌는 자바";

			for (int i = 0; i < content.length(); i++) { // 글자 수만큼 반복

				char ch = content.charAt(i);

				fos.write(ch); // 한 글자씩 연결된 파일로 출력
			}

			System.out.println("출력 완료");

			// 절대 경로 : 절대적인 기준으로부터 목표까지의 경로
			// 서울 기준 : 서울시 중구 남대문로 120 2층 KH정보교육원
			// C드라이브 기준 -> C:/
			// 상대 경로 : 임의의 기준(현재 위치)으로부터 목표까지의 경로
			// KH정보교육원 기준 우리은행 본점까지의 경로 : 옆 건물

			// 현재 프로젝트(a11_io) 폴더가 현재 위치(기준)
			// 현재 위치에서 byte 폴더까지의 경로 : byte

		} catch (IOException e) {
			e.printStackTrace();

		} finally { // 무조건 실행

			// 사용 완료된 스트림을 메모리에 반환하는 코드 작성
			// (close() 코드)
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	// 문자 기반 파일 출력
	public void charOutput() {
		// 프로그램 -> 파일에 씀
		FileWriter fw = null;

		try {
			fw = new FileWriter("char/charTest.txt");
			// char 폴더의 charTest.txt가 있으면 문자 출력 스트림 연결
			// 없으면 만들어서 연결

			String content = "반가워요\n" + "졸려요\n" + "ㅠㅠ";

			fw.write(content); //

			System.out.println("char 기반 출력 완료");

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {
				if (fw != null) {
					fw.close();
				} // fw stream 객체가 있을 때에만 닫기(메모리 반환)

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 바이트 기반 파일 입력
	public void byteInput() {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream("노래가사/SuperShy.txt");

//			읽어온 한 글자를 저장할 변수 선언
			int value = 0;
			// byte를 다루기 힘들어서 in
			while (true) {
				try {
					value = fis.read();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (value == -1)
					break;

				System.out.print((char) value);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	// 문자 기반 파일 입력
	public void charInput() {
		FileReader fr = null;

		try {
			fr = new FileReader("노래가사/SuperShy.txt");

//			읽어온 한 글자를 저장할 변수 선언
			int value = 0;
			// byte를 다루기 힘들어서 in
			while (true) {
				try {
					value = fr.read();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (value == -1)
					break;

				System.out.print((char) value);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	/// file 복사하기
	public void fileCopy() {
		Scanner sc = new Scanner(System.in);

		// byte 기반 스트림 이용
		// + 성능 향상을 위한 보조 스트림

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			System.out.print("복사할 파일 경로 : ");
			String target = sc.nextLine(); // 한 줄 입력

			System.out.println("복사본이 저장될 경로 + 파일명 : ");
			String copy = sc.nextLine();

			// 복사 대상을 읽어올 InputStream 생성 + 보조 스트림으로 성능 향상
			bis = new BufferedInputStream(new FileInputStream(target));
			// 복사할 파일을 출력할 OutputStream 생성 + 보조 스트림으로 성능 향상

			bos = new BufferedOutputStream(new FileOutputStream(copy));

			int value = 0; // 1byte씩 읽어서 저장할 임시 변수

			while (true) {

				value = bis.read();
				// 1byte 읽어오기, 없으면 -1 반환
				if (value == -1)
					break;
				// if, for, while 등 {} 안에 코드가 1줄이면 생략 가능
				bos.write(value);
			}

			System.out.print("복사 완료");
			
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일이 존재하지 않습니다");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 다 쓴 스트림 제거(메모리 반환)

			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bis.close();

				// 보조 스트림을 close() 하면

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 객체 출력 보조 스트링
	public void objectOutput() {
		
		// ObjectOutputStream
		// 객체를 바이트 기반으로 출력하는 보조 스트림
		// 사용 조건 :
		// 출력하려는 객체에 직렬화 가능 여부를 나타내는 Serializable 인터페이스를 상속 받아야 한다.
		
		ObjectOutputStream oos = null;
		
		try {
			// java.io.file : 파일/ 폴더를 참조하는 객체
			File folder = new File("object");
			if(!folder.exists()) { // object라는 폴더가 존재하지 않는다면
				folder.mkdir(); // make directory(==folder) : 폴더 만들기
			}
			oos = new ObjectOutputStream(new FileOutputStream("object/Member.txt"));
			
			// 내보낼 회원 객체 생성
			Member ms= new Member("aa123", "a12345", "네", 777);
			
			// 회원 객체를 파일로 출력 
			oos.writeObject(ms);
			
			System.out.println("회원 출력 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		} try {
			if(oos != null) oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	// 객체 입력 보조 스트림 활용
	public void objectInput() {
		
		ObjectInputStream ois = null;
		
		try {
			// FileNotFoundException
			// IOException
			// 둘 다 한 번에 잡아서 처리
			
			// 파일 내 객체를 읽어오는 스트림 생성		
			ois = new ObjectInputStream( new FileInputStream("object/Member.txt"));
			// readObject() : 직렬화된 객체를 읽어와서 역직렬화 한다.
			
			Member ms = (Member)ois.readObject();
			System.out.print(ms);
			
		} catch(Exception e) { // Exception -> 모든 예외의 최상위 부모
			e.printStackTrace();
		} finally {
		
			try {
				if(ois != null) ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
}
