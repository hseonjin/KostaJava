package connection;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
	// DB Connection
	public static Connection getConnection() {
		Connection conn = null;
		try { 
			Class.forName("org.mariadb.jdbc.Driver"); // driver 설정
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/kotest", "root", "mimi2818"); // URL, User, Password
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// Connection Close
	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Statement 호출, Query문 작성
	public static void insertUser(String id, String name) {
		Connection conn = getConnection();
		Statement stmt = null;
		String sql = String.format("insert into user (id, name) values ('%s', '%s')", id, name);
		try {
			stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(sql); // executeUpdate(sql_query) : insert, delete, update 할 때 사용
			System.out.println(cnt + "개 데이터 삽입");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { // Statement Close
				if(stmt!=null) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			close(conn); // Connection Close
		}
	}
	
	// updateUserName
	public static void updateUserName(String id, String name) {
		Connection conn = getConnection();
		Statement stmt = null;
		String sql = String.format("UPDATE user SET NAME = '%s' WHERE id = '%s'", name, id);
		try {
			stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(sql); // executeUpdate(sql_query) : insert, delete, update 할 때 사용
			System.out.println(cnt + "개 데이터 변경");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { // Statement Close
				if(stmt!=null) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			close(conn); // Connection Close
		}
	}
	
	// deleteUser
	public static void deleteUser(String id) {
		Connection conn = getConnection();
		Statement stmt = null;
		String sql = String.format("Delete from user where id = '%s'",  id);
		try {
			stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "개 데이터 삭제");
		} catch (Exception e) {
			e.printStackTrace();
		} try {
			if(stmt!=null) stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		close(conn);
	}
	
	
	public static void userInfo(String id) {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null; // select 쿼리의 결과를 가짐
		try {
			String sql = String.format("Select * from user where id = '%s'", id);
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs!=null && rs.next()) {
				String rid = rs.getString("id"); // index 또는 컬럼명
				String rname = rs.getString("name");
				System.out.println(rid + ", " + rname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if (stmt!=null) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			close(conn);
		}
	}
	
	public static void allUserInfo() {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs!=null) {
				while(rs.next()) {
					String rid = rs.getString(1); // 인덱스 사용
					String rname = rs.getString(2); // 인덱스 사용
					System.out.println(rid + ", " + rname);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if (stmt!=null) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			close(conn);
		}
	}
	
	public static void main(String[] args) {
//		insertUser("song", "송길동"); // 데이터 삽입
//		updateUserName("song", "송송이"); // 데이터 수정
//		deleteUser("song");
//		userInfo("hong");
		allUserInfo();
	}

}
