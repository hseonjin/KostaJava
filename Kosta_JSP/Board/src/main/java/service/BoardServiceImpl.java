package service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.BoardDAO;
import dao.BoardDAOImpl;
import dto.Board;
import util.PageInfo;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO boardDAO;
	
	public BoardServiceImpl() {
		boardDAO = new BoardDAOImpl();
	}

	@Override
	public void boardWrite(Board board) throws Exception {
		boardDAO.insertBoard(board);
	}

	@Override
	public Map<String, Object> boardListByPage(Integer page) throws Exception {
		int boardCount = boardDAO.selectBoardCount();
		int maxPage = (int)Math.ceil((double)boardCount/10);
		int startPage = (page-1)/10*10+1; // 1, 11, 21, 31....
		int endPage = startPage+10-1;
		if(endPage>maxPage) endPage=maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setAllPage(maxPage);
		pageInfo.setCurPage(page);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		int row = (page-1)*10+1; // 현재 페이지의 시작 row
		
		List<Board> boardList = boardDAO.selectBoardList(row-1);
		
		Map<String, Object> map = new HashMap<>();
		map.put("pageInfo", pageInfo);
		map.put("boardList", boardList);
		
		return map;
	}
}