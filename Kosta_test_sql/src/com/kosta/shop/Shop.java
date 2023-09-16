package com.kosta.shop;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kosta.dao.GoodsDAO;
import com.kosta.dao.OrderDAO;
import com.kosta.order.Order;
import com.kosta.product.Goods;

public class Shop {
	// 구현해야 하는 부분: ApplicationMain.java 오류 없이 작동하도록 필요한 모든 메서드를 구현한다.

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

	// 상품 추가
	public void addProduct(Goods goods) {
		int cnt = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into goods values (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getCode());
			pstmt.setString(2, goods.getName());
			pstmt.setInt(3, goods.getPrice());
			pstmt.setInt(4, goods.getStock());
			pstmt.setString(5, goods.getCategory());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		close(conn);
	}

	// 주문 추가 -> 주문하면 amount만큼 stock 줄이기
	public int order(Order order) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into orders values(?,?,?,?,?)";
		updateProduct(order);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getNo());
			pstmt.setString(2, order.getCustomer());
			pstmt.setString(3, order.getProductCode());
			pstmt.setInt(4, order.getAmount());
			pstmt.setBoolean(5, order.isCanceled());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		close(conn);
		return order.getNo();
	}

	// 재고 관리 (주문/주문취소)
	public void updateProduct(Order order) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update goods set stock=stock+? where code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			if (order.isCanceled() == false) {
				pstmt.setInt(1, order.getAmount() * -1);
			} else {
				pstmt.setInt(1, order.getAmount());
			}
			pstmt.setString(2, order.getProductCode());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		close(conn);
	}

	// 상품 정보 조회
	public Goods findProductByCode(String code) {
		Goods goods = null;
		Connection conn = getConnection();
		String sql = "select * from goods where code=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				String rcode = rs.getString(1);
				String name = rs.getString(2);
				Integer price = rs.getInt(3);
				Integer stock = rs.getInt(4);
				String category = rs.getString(5);
				goods = new Goods(rcode, name, price, stock, category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		close(conn);
		return goods;
	}

	// 전체 상품 정보 출력
	public void printAllProductInfo() {
		List<Goods> goodList = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from goods";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs != null) {
				while (rs.next()) {
					String code = rs.getString(1);
					String name = rs.getString(2);
					Integer price = rs.getInt(3);
					Integer stock = rs.getInt(4);
					String category = rs.getString(5);
					if (category == "1")
						goodList.add(new Goods(code, name, price, stock, "정상"));
					else
						goodList.add(new Goods(code, name, price, stock, "취소"));
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
		for (Goods good : goodList) {
			System.out.println(good);
		}
		close(conn);
	}

	public void printAllOrderInfo() {
		List<Order> orderList = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from orders";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs != null) {
				while (rs.next()) {
					Integer no = rs.getInt(1);
					String customer = rs.getString(2);
					String productcode = rs.getString(3);
					Integer amount = rs.getInt(4);
					boolean iscanceled = rs.getBoolean(5);
					orderList.add(new Order(no, customer, productcode, amount, iscanceled));
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
		for (Order order : orderList) {
			System.out.println(order);
		}
		close(conn);
	}

	public Order findOrderByNo(int orderNo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order order = null;
		String sql = "select * from orders where no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				Integer no = rs.getInt(1);
				String customer = rs.getString(2);
				String productcode = rs.getString(3);
				Integer amount = rs.getInt(4);
				Boolean iscanceled = rs.getBoolean(5);
				order = new Order(no, customer, productcode, amount, iscanceled);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		close(conn);
		return order;
	}

	public Order cancelOrder(int orderNo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update orders set iscanceled=? where no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1); // 0 true, 1 false
			pstmt.setInt(2, orderNo);
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		Order order = findOrderByNo(orderNo);
		updateProduct(order);
		close(conn);
		return order;
	}

	public void printOrderDetailsByCustomerAndIsCanceled(String customerName, String cancelYN) {
		Connection conn = getConnection();
		String sql = "select customer, COUNT(*), SUM(g.price * amount) from orders o join goods g on productcode=g.code where customer=? and iscanceled=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customerName); 
			if(cancelYN.equals("정상")) {
				pstmt.setInt(2, 0);
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next()) {
					String customer = rs.getString(1);
					Integer count = rs.getInt(2);
					Integer tot = rs.getInt(3);
					System.out.println(String.format("%s님의 정상주문 건수는: %d건이고, 정상주문합계금액은: %d원 입니다.",
							customer, count, tot));			
				}
			} 
			else {
				pstmt.setInt(2, 1);
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next()) {
					String customer = rs.getString(1);
					Integer count = rs.getInt(2);
					Integer tot = rs.getInt(3);
					System.out.println(String.format("%s님의 취소주문 건수는: %d건이고, 최소주문합계금액은: %d원 입니다.",
							customer, count, tot));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		close(conn);
	}
}
