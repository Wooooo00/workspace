package edu.kh.project.board.model.service;

import java.util.Map;

import edu.kh.project.board.model.dto.Board;

/** @param
 * 
 */
public interface BoardService {

	Map<String, Object> selectBoardList(int boardCode, int cp);

	Board boardDetail(Map<String, Object> map);

	
}
