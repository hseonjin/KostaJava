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
	// 좋아요 (수, 클릭 여부)
	String boardLike(String id, Integer num) throws Exception;
	// 특정 멤버의 좋아요 체크 여부
	Boolean isBoardLike(String id, Integer num) throws Exception;
}
