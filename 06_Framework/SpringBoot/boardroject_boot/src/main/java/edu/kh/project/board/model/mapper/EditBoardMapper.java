package edu.kh.project.board.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImg;

@Mapper
public interface EditBoardMapper {

	int deleteBoard(Map<String, Integer> paramMap);

	/** 게시글 부분만 삽입
	 * 
	 * 
	 */
	int insertBoard(Board board);

	/** @param UploadList
	 *  @return result (insert 성공한 행의 수 )
	 *  
	 */
	
	int insertuploadList(List<BoardImg> uploadList);
	
	
}
