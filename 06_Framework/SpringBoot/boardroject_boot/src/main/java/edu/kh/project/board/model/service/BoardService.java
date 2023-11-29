package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map; 

import edu.kh.project.board.model.dto.Board;

/** @param 
 * 
 */
/**
 * 
 */
public interface BoardService {

	Map<String, Object> selectBoardList(int boardCode, int cp);
	
	
	

	/** 검색 목록 조회
	 * @param paramMap
	 * @param cp
	 * @return
	 */
	Map<String, Object> searchBoardList(Map<String, Object> paramMap, int cp);
	
	
	
	Board boardDetail(Map<String, Object> map);

	int likeCheck(Map<String, Object> map);

	// 좋아요 처리
	/** @param
	 * 
	 */
	/**
	 * 
	 */
	int like(Map<String, Object> paramMap);

	int updateReadCount(int boardNo);




	List<Map<String, Object>> selectBoardTypeList();


	
}
