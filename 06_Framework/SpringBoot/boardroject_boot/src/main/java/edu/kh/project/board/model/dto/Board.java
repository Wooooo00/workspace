package edu.kh.project.board.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// DTO (Data Transfer Object) : 데이터 전달용 객체
// - 클래스 간의 이동(레이어 이동) 시 필요한 데이터를 한 번에 담아 전달하는 용도의 객체

// !! DTO 사용 시 많이 하는 실수 !! 
// DB의 테이블 컬럼 수와는 상관이 없다
// 필요한 데이터만큼 필요한 형태로 필드 작성하면 됨!!

@Getter
@Setter
@ToString
public class Board {

	
	// 보드 테이블과 맵핑되는 필드 
    private int boardNo;
    private String boardTitle;
    private String boardContent;
    private String boardWriteDate;
    private String boardUpdateDate;
    private int readCount;
    private String boardDelFl;
    private int memberNo;
    private int boardCode;
	
    
    // 목록 조회, 상세 조회 시 맵핑 되는 필드
    
    private int commentCount;
    private int likeCount;
    private String memberNickname;
    private String thumbnail; 
    
    
    
    
}
