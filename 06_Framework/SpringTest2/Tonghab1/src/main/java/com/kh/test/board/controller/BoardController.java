package com.kh.test.board.controller;


import java.util.List;

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
	
	public String inputTitle(String inputTitle, Model model) {
		
		
	
		List<Board> boardList = service.boardList(inputTitle);
		
		if(boardList.isEmpty()) {
			
			
			model.addAttribute("message", "조회 결과가 없습니다");
			
			return "searchFail";
		}
			// 여러행 조회 -> 컬렉션
		
		else {
			
			return "searchSuccess";
			
		}
		
	}	
			
	
}	
	

