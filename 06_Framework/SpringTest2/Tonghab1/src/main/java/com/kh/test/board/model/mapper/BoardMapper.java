package com.kh.test.board.model.mapper;

import java.util.List;

import com.kh.test.board.model.dto.Board;

public interface BoardMapper {




	List<Board> boardList(String inputTitle);

	
}
