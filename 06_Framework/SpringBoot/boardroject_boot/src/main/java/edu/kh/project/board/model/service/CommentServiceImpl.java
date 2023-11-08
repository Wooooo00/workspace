package edu.kh.project.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.board.model.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor

public class CommentServiceImpl implements CommentService{
	
	private final CommentMapper mapper;
	
	// 댓글 목록 조회
	@Override
	public List<Comment> select(int boardNo) {
		// TODO Auto-generated method stub
		return mapper.select(boardNo);
	}
	
	// 댓글 등록
	@Override
	public int insert(Comment comment) {
		// TODO Auto-generated method stub
		return mapper.insert(comment);
	}
	
}
