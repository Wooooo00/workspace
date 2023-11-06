package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.Board;

public interface EditBoardService {

	int deleteBoard(Map<String, Integer> paramMap);

	int insertBoard(Board board, List<MultipartFile> images) 
			throws IllegalStateException, IOException;

	int updateBoard(Board board, List<MultipartFile> images, String deleteOrder) throws IllegalStateException, IOException;
	
	

}
