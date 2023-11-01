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

	@GetMapping("inputWriter")
	public String inputWriter(String inputWriter, Model model) {
		
		List<Board> inputWriterList = service.inputWriterList(inputWriter);
		
		if(inputWriterList.isEmpty()) {
			return "searchFail";
			
		} else {
			
			model.addAttribute("inputWriterList", inputWriterList);
			return "searchSuccess";
			
		}
		
		
	}
	
}
