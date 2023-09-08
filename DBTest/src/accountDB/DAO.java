package accountDB;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DAO {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties db = new Properties(); // Property 사용
			db.load(new FileInputStream("db.properties"));
			Class.forName(db.getProperty("driver"));
			conn = DriverManager.getConnection(db.getProperty("url"), db.getProperty("user"),
					db.getProperty("password"));
		} catch (Exception e) {
			// File 예외처리와 getConnection의 예외를 한번에 처리)
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 전체 계좌 출력
	public static Account selectAccount(Connection conn, String id) {
		Account acc = null;
		String sql = "select * from account where id=?"; // 가변으로 바꿔줘야 하는 부분을 ? 로 작성
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql); // 미완성된 쿼리문을 그대로 넣어줌
			pstmt.setString(1, id); // JDBC는 순서를 1부터 시작
			rs = pstmt.executeQuery(); // select는 query
			if (rs != null && rs.next()) {
				String rid = rs.getString(1); // 인덱스로 가져오기
				String rname = rs.getString("name"); // 칼럼명으로 가져오기
				Integer rbalance = rs.getInt("balance");
				String rgrade = rs.getString("grade");
				acc = new Account(rid, rname, rbalance, rgrade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acc;
	}

	public static int insertAccount(Connection conn, Account acc) {
		int cnt = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into account values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			pstmt.setString(4, acc.getGrade());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public static int updateAccount(Connection conn, Account acc) {
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "update account set balance=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql); // db에 연결해서 sql문을 넣기
			pstmt.setInt(1, acc.getBalance());
			pstmt.setString(2, acc.getId());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public static List<Account> selectAccountList(Connection conn) {
		List<Account> accList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from account";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs != null) {
				while (rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					Integer balance = rs.getInt(3);
					String grade = rs.getString(4);
					accList.add(new Account(id, name, balance, grade));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return accList;
	}
}
