package main;

import java.util.Scanner;

import service.BaseballService;

public class Baseball {

	public static void main(String[] args) {
		BaseballService service = new BaseballService();
		int sel;

		while (true) {
			try {
				sel = service.menu();
				if (sel == 9)
					break;

				switch (sel) {
				case 1:
					service.regTeam(); break; // 팀 등록
				case 2:
					service.getTeam(); break; // 특정 팀 조회
				case 3:
					service.getTeamList(); break; // 팀 목록 조회
				case 4:
					service.regPlayer(); break; // 선수 등록
				case 5:
					service.getPlayerByName(); break; // 특정 선수 조회(이름)
				case 6:
					service.getPlayerByBacknum(); break; // 특정 선수 조회(등번호)
				case 7:
					service.getPlayerByNum(); break; // 특정 선수 조회(선수번호)
				case 8:
					service.getPlayerList(); break; // 특정 팀 선수 목록 조회
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}