package service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

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
		int endPage = startPage+10-1; // 10, 20, 30, ,,,
		if(endPage>maxPage) endPage=maxPage;
		if(page>maxPage) page=maxPage; // 글을 삭제하여 조회 당시 페이지보다 결과 페이지가 작은 경우
		
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

	@Override
	public Board boardDetail(Integer num) throws Exception {
		boardDAO.updateBoardViewCount(num);
		return boardDAO.selectBoard(num);
	}

	@Override
	public void boardModify(Board board) throws Exception {
		boardDAO.updateBoard(board);
	}

	@Override
	public void boardDelete(Integer num) throws Exception {
		boardDAO.deleteBoard(num);
	}

	@Override
	public Map<String, Object> boardSearch(String type, String keyword, Integer page) throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("type", type);
		param.put("keyword", keyword);
		
		PageInfo pageInfo = new PageInfo();
		int boardCount = boardDAO.searchBoardCount(param);
		int maxPage = (int)Math.ceil((double)boardCount/10);
		int startPage = (page-1)/10*10+1;  //1,11,21,31...
		int endPage = startPage+10-1; //10,20,30...
		if(endPage>maxPage) endPage=maxPage;
		if(page>maxPage) page=maxPage;
		
		pageInfo.setAllPage(maxPage);
		pageInfo.setCurPage(page);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		Map<String, Object> map = new HashMap<>();
		map.put("pageInfo", pageInfo);

		if(page==0) {
			return map;
		}
		
		int row = (page-1)*10+1;  //현재 페이지의 시작 row
		param.put("row", row-1);
		List<Board> boardList = boardDAO.searchBoardList(param);
		
		map.put("boardList", boardList);
		map.put("type", type);
		map.put("keyword", keyword);
		return map;
	}

	@Override
	public String boardLike(String id, Integer num) throws Exception {
		Map<String, Object> param = new HashMap<>(); // String과 Integer를 가져오기 때문에 Object로!
		param.put("id", id); // mapper에 지정한 값과 이름이 같아야 함
		param.put("num", num);
		
		// 1. boardlike 테이블에 데이터 있는지 확인(member_id, num)
		Integer likenum = boardDAO.selectBoardLike(param);
		Map<String, Object> res = new HashMap<>();
		
		// 2. 있으면 boardlike 삭제, 없으면 boardlike 삽입
		// 3. board 테이블에 좋아요 수 조정 (삭제-1, 삽입+1)
		if(likenum==null) { // 없으면
			boardDAO.insertBoardLike(param); // boardlike에 삽입
			boardDAO.plusBoardLikeCount(num); // board 테이블에 좋아요 수 증가 likenum 또는 num 가능
			res.put("select",  true);
		} else {
			boardDAO.deleteBoardLike(param);
			boardDAO.minusBoardLikeCount(num);
			res.put("select", false);
		}
		// 4. 좋아요 수 리턴
		Integer likecount = boardDAO.selectLikeCount(num);
		res.put("likecount", likecount);
		
		JSONObject jsonObj = new JSONObject(res);
		
		return jsonObj.toJSONString();
	}

	@Override
	public Boolean isBoardLike(String id, Integer num) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("num", num);
		Integer likenum = boardDAO.selectBoardLike(param);
		if(likenum==null) return false;
		return true;
	}

	
}