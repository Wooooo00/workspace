package edu.kh.project.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.board.model.service.CommentService;
import lombok.RequiredArgsConstructor;

@RestController // 
@RequiredArgsConstructor
public class CommentController {
		
	private final CommentService service;
	
	// HttpMessageConverter 
	// 	비동기 통신 할 때 반환되는 값을 JS에 맞는 자료형으로 변환시켜준다.
	//	String, int, double -> text/plain (글자로 반환)  
	//	객체, 컬렉션 -> application/json (JSON으로 반환)
	//  JSON JavaScript Object Notation JS 객체 표기법
	//  JS 객체 모양의 문자열 
	
	
	
	/**
	 * @param boardNo
	 * @return
	 */
	// java.util.list
	// produces = "application/json" -> 반환되는 값이 단순 문자열이 아니라 
	// JSON이라 명시한다
	// JS에서 이것을 인식하고 JSON -> Object로 파싱 가능
	@GetMapping(value="comment", produces = "application/json")
	public List<Comment> select(int boardNo){
		
		return service.select(boardNo);
	}
	
	// @RequestBody
	// 비동기 요청 body에 담긴 내용을 얻어와
	// 옆에 작성된 매개 변수에 대입
	
	/**	
	 * @param comment : 커맨드 객체 
	 * @return
	 */
	@PostMapping("comment")
	public int insert(@RequestBody Comment comment) {
		return service.insert(comment);
	}
	
	
	
}
