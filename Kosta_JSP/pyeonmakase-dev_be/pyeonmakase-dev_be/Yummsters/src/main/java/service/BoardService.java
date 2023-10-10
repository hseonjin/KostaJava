package service;

import java.util.List;
import java.util.Map;

import bean.Board;
import bean.Board_Store;

public interface BoardService {
    void boardRegister(Board board) throws Exception;
    void board_store(Board_Store boardStore) throws Exception;
    Board boardDetail(Integer board_id) throws Exception;

    // 선진 작성 부분
    // main-list
    List<Board> boardAllList() throws Exception;
    // main_list by foodCategory
	List<Board> boardListByFood(Integer foodId) throws Exception;
	
	List<Board> boardListByCate(Integer foodId, List<Integer> storeId);
	
	// 검색
	List<Board> boardSearch(String keyword) throws Exception;
}