package com.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kosta.order.Order;

public class OrderDAO {
	// 주문 추가
	public void addOrder(Order order) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		updateStock(order);
		String sql = "insert into orders values (?,?,?,?,?)";
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
		}
		DBConnection.close(conn);
	}
	
	// 주문 시 재고 관리
	public void updateStock(Order order) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update goods set stock=stock+? where code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			if(order.isCanceled() == false) {
				pstmt.setInt(1, order.getAmount()*-1);
			} else {
				pstmt.setInt(1, order.getAmount());
			}
			pstmt.setString(2, order.getProductCode());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		DBConnection.close(conn);
	}
}
