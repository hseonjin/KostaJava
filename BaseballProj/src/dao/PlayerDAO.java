package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;

import dto.Player;

public class PlayerDAO {
	
	// Connection 메소드
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties db = new Properties(); // Properties 사용 -> key와 value를 String 타입으로 제한한 컬렉션
			db.load(new FileInputStream("db.properties"));
			Class.forName(db.getProperty("driver"));
			conn = DriverManager.getConnection(db.getProperty("url"), db.getProperty("user"),
					db.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// close 메소드
	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ------------------------------------------
	// 선수 관련 메소드
	//선수 등록
	public static int insertPlayer(Connection conn, Player player) {
		int cnt = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into player (name, backnum, teamnum) "
				+ "VALUE (?, ?, (select num from team where name = ?))";
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, player.getName());
			pstmt.setInt(2, player.getBacknum());
			pstmt.setString(3, player.getTeamname());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	//특정 선수 조회(선수이름)
	public static Player selectPlayerByName(Connection conn, String name) {
		Player player = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select p.*, t.name "
				+ "from player p join team t on p.teamnum = t.num "
				+ "where p.name = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				Integer num = rs.getInt(1);
				String rname = rs.getString(2);
				Integer backnum = rs.getInt(3);
				Integer teamnum = rs.getInt(4);
				String teamname = rs.getString(5);
				player = new Player(num, rname, backnum, teamnum, teamname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return player;
	}
	
	//특정 선수 조회(등번호)
	public static Player selectPlayerByBacknum(Connection conn, Integer backnum) {
		Player player = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select p.*, t.name "
				+ "from player p join team t on p.teamnum = t.num "
				+ "where p.backnum = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, backnum);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				Integer num = rs.getInt(1);
				String name = rs.getString(2);
				Integer rbacknum = rs.getInt(3);
				Integer teamnum = rs.getInt(4);
				String teamname = rs.getString(5);
				player = new Player(num, name, rbacknum, teamnum, teamname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return player;
	}
	
	//특정 선수 조회(선수번호)
	public static Player selectPlayerByNum(Connection conn, Integer num) {
		Player player = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select p.*, t.name from player p join team t on p.teamnum = t.num where p.num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				Integer rnum = rs.getInt(1);
				String name = rs.getString(2);
				Integer backnum = rs.getInt(3);
				Integer teamnum = rs.getInt(4);
				String teamname = rs.getString(5);
				player = new Player(rnum, name, backnum, teamnum, teamname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return player;
	}
	
	//특정팀 소속 선수 목록 조회
	public static List<Player> selectPlayerByTeam(Connection conn, String teamName) {
		List<Player> playerList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM player "
				+ "WHERE teamnum = (SELECT num FROM team WHERE NAME = ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teamName);
			rs = pstmt.executeQuery();
			if(rs != null) {
				while (rs.next()) {
					Integer num = rs.getInt(1);
					String name = rs.getString(2);
					Integer backnum = rs.getInt(3);
					Integer teamnum = rs.getInt(4);
//					String teamname = rs.getString(5); // Wrong index position. Is 5 but must be in 1-4 range
					playerList.add(new Player(num, name, backnum, teamnum, teamName));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerList;
	}
}
