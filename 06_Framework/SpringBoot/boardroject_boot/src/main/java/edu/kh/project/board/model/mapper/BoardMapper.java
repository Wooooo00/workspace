package edu.kh.project.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	List<Board> selectBoardList(int boardCode);

	

	
	
}
