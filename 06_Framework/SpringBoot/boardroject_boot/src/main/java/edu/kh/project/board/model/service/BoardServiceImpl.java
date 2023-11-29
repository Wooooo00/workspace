package edu.kh.project.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.Pagination;
import edu.kh.project.board.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class) // 모든 예외 발생 시 롤백s
@RequiredArgsConstructor // 파이널 필드에 bean DI

public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper mapper;
	
	@Override
	public Map<String, Object> selectBoardList(int boardCode, int cp) {
		// TODO Auto-generated method stub
	
		// 게시글 목록 조회에 페이지네이션(Pagination) 처리 시 
				// 중요한 값 또는 객체(cp)
				// 1. 현재 페이지 (cp)
				// 2. 게시판 전체 게시글 수 (listCount)
				// 3. rowbounds 마이바티스 객체 
				
				// 전체 게시글 수 조회
				
		int listCount = mapper.getListCount(boardCode);
		
		// 
		
		Pagination pagination = new Pagination(cp, listCount);
		
		/*  - RowBounds 객체 생성(마이바티스)
		 * 	
		 * 	- RowBounds란?? 
		 * 	- Row(행), Bound
		 *  - 전체 조회 결과 중 지정된 행(offset)만큼 건너뛴 다음
		 * 	  읽어올 행의 개수(limit)만큼만 조회
		 * */
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		int limit = pagination.getLimit();
		
		RowBounds rowbounds = new RowBounds(offset, limit);
		
		// 마이바티스로 SQL 수행 시
		// SQL에 전달할 수 있는 파라미터의 개수는 1개(첫 번째 매개변수)
		// 두 번째 매개변수는 RowBounds만 가능
				
		
		List<Board> boardList = mapper.selectBoardList(boardCode, rowbounds);
		
		Map<String, Object> map = new HashMap<>();
		map.put("boardList", boardList);
		map.put("pagination", pagination);
		
		return map;
	}
	
	// 검색 조건 일치 게시글 수 조회
	
	@Override
	public Map<String, Object> searchBoardList(Map<String, Object> paramMap, int cp) {
		// TODO Auto-generated method stub
		
		int listCount = mapper.searchListCount(paramMap);
		// 
		Pagination pagination = new Pagination(cp, listCount);
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		int limit = pagination.getLimit();
		
		RowBounds rowbounds = new RowBounds(offset, limit);
		
		// 게시글 일치 게시글 목록 조회
		List<Board> boardList = mapper.searchBoardList(paramMap, rowbounds);
		
		
		// Map에 담아서 반환
		Map<String, Object> map = new HashMap<>();
		map.put("boardList", boardList);
		map.put("pagination", pagination);
		
		return map;
		
	}
	
	
	
	// 
	@Override
	public Board boardDetail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.boardDetail(map);
	}
	
	
	 @Override
	public int likeCheck(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.likeCheck(map);
	}
	 
	@Override
	public int like(Map<String, Object> paramMap) {
		
		int result = 0; // Mapper 호출 결과 저장 변수
		
		// 기존에 좋아요 상태 == check가 1 
		// -> 좋아요 해제 == BOARD_LIKE 테이블에서 DELETE
		
		if( (Integer) (paramMap.get("check")) == 1 ) {
			result = mapper.deleteBoardLike(paramMap);
			
		} else {
			
			result = mapper.insertBoardLike(paramMap);
		}
		
		// 안 한 상태 == check가 0
		// -> 좋아요 삽입 == BOARD_LIKE 테이블에 INSERT
			
		// SQL 수행 결과가 0 == 파라미터에 문제가 있다
		if(result == 0) return -1;
		
		// SQL 성공시 
		// 현재 게시글의 좋아요 수를 조회해서 반환
		
		return mapper.countBoardLike( (Integer)(paramMap.get("boardNo")) );
	}
	
	// 조회 수 증가 
	@Override
	public int updateReadCount(int boardNo) {
		// TODO Auto-generated method stub
		return mapper.updateReadCount(boardNo);
	}
	
	@Override
	public List<Map<String, Object>> selectBoardTypeList() {
		return mapper.selectBoardTypeList();
	}
	
}
