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

	int likeCheck(Map<String, Object> map);

	
	// 좋아요 테이블 행 삭제
	int deleteBoardLike(Map<String, Object> paramMap);

	// 좋아요 테이블 행 삽입
	int insertBoardLike(Map<String, Object> paramMap);

	int countBoardLike(Integer integer);

	int updateReadCount(int boardNo);
	;
}
