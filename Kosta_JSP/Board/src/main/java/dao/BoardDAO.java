package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.Board;

public interface BoardDAO {
	void insertBoard(Board board) throws Exception;
	List<Board> selectBoardList(Integer row) throws Exception;
	Integer selectBoardCount() throws Exception;
	Board selectBoard(Integer num) throws Exception;
	void updateBoard(Board board) throws Exception;
	void deleteBoard(Integer num) throws Exception;
	// 검색
	Integer searchBoardCount(Map<String, Object> param) throws Exception;
	List<Board> searchBoardList(Map<String,Object> param) throws Exception;
	// 조회수
	void updateBoardViewCount(Integer num) throws Exception;
	// 좋아요
	Integer selectBoardLike(Map<String, Object> param) throws Exception;
	void insertBoardLike(Map<String, Object> param) throws Exception;
	void deleteBoardLike(Map<String, Object> param) throws Exception;
	
	Integer selectLikeCount(Integer num) throws Exception;
	void plusBoardLikeCount(Integer num) throws Exception;
	void minusBoardLikeCount(Integer num) throws Exception;
}
