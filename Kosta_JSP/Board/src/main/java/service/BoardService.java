package service;

import java.util.Map;

import dto.Board;

public interface BoardService {
	void boardWrite(Board board) throws Exception;
	
	// pageinfo 정보와 list를 view에 함께 보내주어야하므로 Map을 사용함
	Map<String, Object> boardListByPage(Integer page) throws Exception;
}
