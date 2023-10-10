package dao;

import java.util.List;
import java.util.Map;

import bean.Board;
import bean.Board_Store;

public interface BoardDAO {
    void insertBoard(Board board) throws Exception;
    void insertStore_category(Board_Store boardStore) throws Exception;
    Board selectBoardOne(Integer board_id) throws Exception;
    List<Board> selectBoardListTop10(Integer row) throws Exception;
    
    // 선진 작성 부분---
    // main_list
    List<Board> selectBoardList() throws Exception;
    // main_list by Category
    List<Board> selectBoardByFood(Integer foodId) throws Exception;
    
    // 카테고리별 리스트
    List<Board> selectBoardByCate(Integer foodId, List<Integer> storeId);
    
    // 검색
    List<Board> searchByKeyword(String keyword) throws Exception;
}
