package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Board;
import bean.Board_Store;
import dao.BoardDAO;
import dao.BoardDAOImpl;

public class BoardServiceImpl implements BoardService{
    private BoardDAO boardDao;

    public BoardServiceImpl(){
        boardDao = new BoardDAOImpl();
    }

    // 레시피 게시글 등록
    @Override
    public void boardRegister(Board board) throws Exception {
        boardDao.insertBoard(board);
    }

    // 레시피 게시글과 편의점 카테고리 매핑
    @Override
    public void board_store(Board_Store boardStore) throws Exception {
        boardDao.insertStore_category(boardStore);
    }

    // 게시글 번호로 게시글 정보 조회
    @Override
    public Board boardDetail(Integer board_id) throws Exception {
        return boardDao.selectBoardOne(board_id);
    }

    
    // 선진 작성 부분 
    // main-list
	@Override
	public List<Board> boardAllList() throws Exception {
		return boardDao.selectBoardList();
	}
    // main-list by food
	@Override
	public List<Board> boardListByFood(Integer foodId) throws Exception {
		return boardDao.selectBoardByFood(foodId);
	}

	@Override
	public List<Board> boardListByCate(Integer foodId, List<Integer> storeId) {
		// 중복된 store_category_name을 합쳐서 board 객체에 저장
		List<Board> boardList = boardDao.selectBoardByCate(foodId, storeId);
		
		for(Board board : boardList) {
			List<String> storeNameList = new ArrayList<>();
			for(Board store : boardList) {
				if(store.getBoard_id().equals(board.getBoard_id())) {
					storeNameList.add(store.getStore_category_name());
				}
			}
			String storeNames = String.join(",", storeNameList);
			board.setStore_category_name(storeNames);
		}
		return boardList;
	}
	
	
	// 키워드 검색
	@Override
	public List<Board> boardSearch(String keyword) throws Exception {
		return boardDao.searchByKeyword(keyword);
	}

}