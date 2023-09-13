package com.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kosta.order.Order;

public class OrderDAO {
	public int insertOrder(Order order) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into orders values(?,?,?,?,?)";
		
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
				if (pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DBConnection.close(conn);
		return order.getNo();
	}
}
