package edu.kh.project.board.model.service;

import java.util.Map;

/** @param
 * 
 */
public interface BoardService {

	Map<String, Object> selectBoardList(int boardCode, int cp);

	
}
