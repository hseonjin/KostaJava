package dao;

import java.util.List;

import dto.Board;

public interface BoardDAO {
	void insertBoard(Board board) throws Exception;
	List<Board> selectBoardList(Integer row) throws Exception;
	Integer selectBoardCount() throws Exception;
}
