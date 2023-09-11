package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import dao.PlayerDAO;
import dao.TeamDAO;
import dto.Player;
import dto.Team;

public class BaseballService {
	// 팀 등록
	public void regTeam() {
		Connection conn = TeamDAO.getConnection(); // Connection
		System.out.println("[팀 등록]");
		System.out.println("팀 명: ");
		String name = sc.nextLine();
		Team team = TeamDAO.selectTeam(conn, name);
		if (team != null) {
			System.out.println("중복된 팀명입니다.");
			TeamDAO.close(conn);
		} else {
			System.out.println("연고지: ");
			String local = sc.nextLine();
			int cnt = TeamDAO.insertTeam(conn, new Team(null, name, local));
			if (cnt > 0)
				System.out.println(cnt + "개 팀이 생성되었습니다.");
		}
		TeamDAO.close(conn);
	}

	// 특정 팀 조회
	public void getTeam() {
		Connection conn = TeamDAO.getConnection();
		System.out.println("[팀 조회]");
		System.out.println("팀 명: ");
		String name = sc.nextLine();
		Team team = TeamDAO.selectTeam(conn, name);
		if (team == null) {
			System.out.println("존재하지 않는 팀명입니다.");
			TeamDAO.close(conn);
		} else {
			System.out.println(team);
		}
		TeamDAO.close(conn);
	}

// 팀 목록조회
	public void getTeamList() {
		Connection conn = TeamDAO.getConnection();
		System.out.println("[전체 팀 조회]");
		List<Team> teamList = TeamDAO.selectTeamList(conn);
		for (Team team : teamList) {
			System.out.println(team);
		}
		TeamDAO.close(conn);
	}
	
// 팀 목록조회
	public void getShortTeamList() {
		Connection conn = TeamDAO.getConnection();
		System.out.println("[전체 팀 조회]");
		List<Team> teamList = TeamDAO.selectTeamList(conn);
		for (Team team : teamList) {
			System.out.println(team.shortString());
		}
		TeamDAO.close(conn);
	}

// 선수 등록 -> 이름 중복될 수 있어서 if문 안 씀
	public void regPlayer() {
		Connection conn = PlayerDAO.getConnection();
		System.out.println("[선수 등록]");
		System.out.println("선수명: ");
		String name = sc.nextLine();
		Player p = PlayerDAO.selectPlayerByName(conn, name);
		System.out.println("등번호: ");
		Integer backnum = Integer.parseInt(sc.nextLine());
		System.out.println("<팀 선택>");
		getShortTeamList(); // 팀 목록 나타내기(번호: 팀명)
		System.out.println("팀 명 >> ");
		String teamname = sc.nextLine();
		int cnt = PlayerDAO.insertPlayer(conn, new Player(null, name, backnum, null, teamname));
		if (cnt > 0)
			System.out.println(cnt + "명의 선수가 등록되었습니다");
		PlayerDAO.close(conn);
	}

// 특정 선수 조회(선수이름)
	public void getPlayerByName() {
		Connection conn = PlayerDAO.getConnection();
		System.out.println("[선수 이름으로 조회하기]");
		System.out.println("선수명: ");
		String name = sc.nextLine();
		Player player = PlayerDAO.selectPlayerByName(conn, name);
		if (player == null) {
			System.out.println("존재하지 않는 선수입니다.");
			PlayerDAO.close(conn);
		} else {
			System.out.println(player);
		}
		PlayerDAO.close(conn);
	}

// 특정 선수 조회(등번호)
	public void getPlayerByBacknum() {
		Connection conn = PlayerDAO.getConnection();
		System.out.println("[선수 등번호로 조회하기]");
		System.out.println("선수 등번호: ");
		Integer backnum = Integer.parseInt(sc.nextLine());
		Player player = PlayerDAO.selectPlayerByBacknum(conn, backnum);
		if (player == null) {
			System.out.println("존재하지 않는 선수입니다.");
			PlayerDAO.close(conn);
		} else {
			System.out.println(player);
		}
		PlayerDAO.close(conn);
	}

// 특정 선수 조회(선수번호)
	public void getPlayerByNum() {
		Connection conn = PlayerDAO.getConnection();
		System.out.println("[선수 번호로로 조회하기]");
		System.out.println("선수 번호: ");
		Integer num = Integer.parseInt(sc.nextLine());
		Player player = PlayerDAO.selectPlayerByNum(conn, num);
		if (player == null) {
			System.out.println("존재하지 않는 선수입니다.");
			PlayerDAO.close(conn);
		} else {
			System.out.println(player);
		}
		PlayerDAO.close(conn);
	}

// 특정팀 소속 선수 목록 조회
	public void getPlayerList() {
		Connection conn = PlayerDAO.getConnection();
		System.out.println("[팀별 소속 선수 조회]");
		getTeamList();
		System.out.println("팀명 입력 >> ");
		String teamname = sc.nextLine();
		List<Player> pList = PlayerDAO.selectPlayerByTeam(conn, teamname);
		if (pList.isEmpty()) {
			System.out.println("존재하지 않는 팀입니다.");
			PlayerDAO.close(conn);
		} else {
			for (Player player : pList) {
				System.out.println(player);
			}
		}
		PlayerDAO.close(conn);
	}

	Scanner sc = new Scanner(System.in);

	public int menu() {
		System.out.println("[야구 팀/선수 등록/조회]");
		System.out.println("1. 팀 등록");
		System.out.println("2. 특정 팀 조회");
		System.out.println("3. 팀 목록 조회");
		System.out.println("-------------------------");
		System.out.println("4. 선수 등록");
		System.out.println("5. 특정 선수 조회(이름)");
		System.out.println("6. 특정 선수 조회(등번호)");
		System.out.println("7. 특정 선수 조회(선수번호)");
		System.out.println("8. 특정팀 선수 목록 조회");
		System.out.println("-------------------------");
		System.out.println("9. 종료");
		System.out.println("선택 >> ");
		return Integer.parseInt(sc.nextLine());
	}
}