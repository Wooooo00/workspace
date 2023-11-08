package edu.kh.project.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.board.model.dto.Comment;

@Mapper
public interface CommentMapper {

	// 댓글 목록 조회
	List<Comment> select(int boardNo);

	// 댓글 등록
	int insert(Comment comment);

	// 댓글 수정
	int update(Comment comment);

	// 댓글 삭제
	int delete(int commentNo);

	
}
