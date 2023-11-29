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

	
	// 검색어 일치 게시글 수 조회
	int searchListCount(Map<String, Object> paramMap);
	
	// 검색어 일치 게시글 목록 조회
	List<Board> searchBoardList(Map<String, Object> paramMap, RowBounds rowbounds);

	List<Map<String, Object>> selectBoardTypeList();
	
}
