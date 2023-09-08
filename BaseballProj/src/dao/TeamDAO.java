package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Team;

public class TeamDAO {
	// 팀 등록
	public int insertTeam(Team team) {
		int cnt = 0;
		return cnt;
	}
	
	// 팀 조회
	public Team selectTeam(String teatName) {
		Team team = null;
		return team;
	}
	
	// 특정 팀 목록조회
	public List<Team> selectTeamList() {
		List<Team> teamList = new ArrayList<>();
		
		return teamList;
	}

}
