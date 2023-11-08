package edu.kh.project.board.model.service;

import java.util.List;

import edu.kh.project.board.model.dto.Comment;

public interface CommentService {

	
	/** 댓글 목록 조회
	 * @param boardNo
	 * @return CommentList
	 */
	List<Comment> select(int boardNo);

	
	/** 댓글 등록
	 * @param comment
	 * @return
	 */
	int insert(Comment comment);
	
}
