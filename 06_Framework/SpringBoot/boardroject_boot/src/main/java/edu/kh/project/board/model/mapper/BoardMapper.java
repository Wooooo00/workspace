package edu.kh.project.board.model.mapper;

import java.util.List; 
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.project.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	List<Board> selectBoardList(int boardCode, RowBounds rowbounds);

	int getListCount(int boardCode);

	Board boardDetail(Map<String, Object> map);

	

	
	
}
