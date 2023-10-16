package edu.kh.project.member.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok 라이브러리 : DTO 코드 자동 완성

// 설정 방법
// 1) mvnrepository에서 lombok -> dependency 추가(pom.xml)
// 2) lombok.jar 파일을 다운로드 받은 후 실행
// -> cmd -> java - jar  경로/lombok.jar 
// -> STS3 경로 설정 후 install  
// 3) STS 재시작

// 사용 방법
// lombok에서 제공하는 어노테이션을 DTO 상단에 작성
//
// DTO


@NoArgsConstructor // 기본 생성자 자동 완성
@Getter // 게터 자동완성
@Setter	// 세터 자동완성
@ToString // toString

public class Member {
	
	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberNickname;
	private String memberAddress;
	private String profileImg;
	private String enrollDate;
	private String memberDelFl;
	private String memberTel;
	private int authority;
	
	
}
