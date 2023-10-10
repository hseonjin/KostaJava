package dao;

import bean.Board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Board_Store;
import org.apache.ibatis.session.SqlSession;
import util.MybatisSqlSessionFactory;

public class BoardDAOImpl implements BoardDAO{
    SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

    // 레시피 게시글 등록
    @Override
    public void insertBoard(Board board) throws Exception {
        sqlSession.insert("mapper.board.insertBoard", board);
        sqlSession.commit();
    }

    // 레시피 게시글과 편의점 카테고리 매핑
    @Override
    public void insertStore_category(Board_Store boardStore) throws Exception {
        sqlSession.insert("mapper.board_store.insertBoard_store", boardStore);
        sqlSession.commit();
    }

    // 게시글 번호로 게시글 정보 가져오기
    @Override
    public Board selectBoardOne(Integer board_id) throws Exception {
        return sqlSession.selectOne("mapper.board.selectBoardOne", board_id);
    }

    @Override
	public List<Board> selectBoardListTop10(Integer row) throws Exception {
		return sqlSession.selectList("mapper.board.selectBoardListTop10",row);
	}
    
    // 선진 작성 부분
    // main-list
    public List<Board> selectBoardList() {
    	return sqlSession.selectList("mapper.board.selectBoardList");
    }
    // main-list by foodCategory
	@Override
	public List<Board> selectBoardByFood(Integer foodId) throws Exception {
		return sqlSession.selectList("mapper.board.selectBoardByFood", foodId);
	}
	
	// main-list by category(food, store)
	@Override
	public List<Board> selectBoardByCate(Integer foodId, List<Integer> storeId) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("foodId", foodId);
	    params.put("storeId", storeId);
	    return sqlSession.selectList("mapper.board.selectBoardByCate", params);
	}

    
    // 키워드 검색
	@Override
	public List<Board> searchByKeyword(String keyword) throws Exception {
		return sqlSession.selectList("mapper.board.searchByKeyword", "%" + keyword + "%");
	}
    
}
