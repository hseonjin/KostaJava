package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class PlayerDAO {
	//선수 등록
	public int insertPlayer(Player player) {
		int cnt = 0;
		return cnt;
	}
	
	//특정 선수 조회(선수이름)
	public List<Player> selectPlayerByName(String name) {
		List<Player> playerList = new ArrayList<>();
		
		return playerList;
	}
	
	//특정 선수 조회(등번호)
	public List<Player> selectPlayerByBacknum(Integer backnum) {
		List<Player> playerList = new ArrayList<>();
		
		return playerList;
	}
	
	//특정 선수 조회(선수번호)
	public Player selectPlayerByNum(Integer num) {
		Player player = null;
		return player;
	}
	
	//특정팀 소속 선수 목록 조회
	public List<Player> selectPlayerByTeam(String teamName) {
		List<Player> playerList = new ArrayList<>();
		
		return playerList;
	}
}
