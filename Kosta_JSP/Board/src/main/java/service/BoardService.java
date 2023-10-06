package service;

import java.util.List;
import java.util.Map;

import dto.Board;

public interface BoardService {
	void boardWrite(Board board) throws Exception;
	// pageinfo 정보와 list를 view에 함께 보내주어야하므로 Map을 사용함
	Map<String, Object> boardListByPage(Integer page) throws Exception;
	Board boardDetail(Integer num) throws Exception;
	void boardModify(Board board) throws Exception;
	void boardDelete(Integer num) throws Exception;
	
	// 검색
	Map<String, Object> boardSearch(String type, String keyword, Integer page) throws Exception;
}
