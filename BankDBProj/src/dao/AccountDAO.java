package dao;

import java.awt.Taskbar.State;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import acc.Account;
import acc.SpecialAccount;


public class AccountDAO {
	// Connection
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
	
	// Close
	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 계좌 출력
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
					if (rgrade == null) {
						acc = new Account(rid, rname, rbalance);
					} else {
						acc = new SpecialAccount(rid, rname, rbalance, rgrade);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return acc;
		}
		
	// Insert Account
	public static int insertAccount(Connection conn, Account acc) {
		int cnt = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into account values (?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			if(acc instanceof SpecialAccount) {
				pstmt.setString(4, ((SpecialAccount)acc).getGrade());
			} else {
				pstmt.setString(4, null);
			}
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	// Update Account
	public static int updateAccount(Connection conn, Account acc) {
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "update account set balance=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getBalance());
			pstmt.setString(2, acc.getId());
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
	
	// View All List
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
					if (grade == null) {
						accList.add(new Account(id, name, balance));
					} else {
						accList.add(new SpecialAccount(id, name, balance, grade));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return accList;
	}
}
