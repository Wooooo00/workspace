package com.kh.test.board.controller;

import java.awt.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("inputTitle")
	
	public String inputTitle(Board board, Model model) {
		
		Map<Board, board> = new BoardList<board>;
		
//		Board board = service.inputTitle(board);
		
//		Board <String, object >= service.inputTitle(board);
	
//		List BoarList<board> = List<>; 
		
		if(board == null) {
			
			model.addAttribute("message", "조회 결과가 없습니다");
			
			// 여러행 조회 -> 컬렉션
			
			
			return "searchFail";
			
			
		} else {
			
			
			return "searchSuccess";

		}
		
	}
	
	
}
