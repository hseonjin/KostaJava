package com.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kosta.product.Goods;

public class GoodsDAO {
	
	// 상품 추가
	public void addGoods(Goods goods) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into goods values (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getCode());
			pstmt.setString(2, goods.getName());
			pstmt.setInt(3, goods.getPrice());
			pstmt.setInt(4, goods.getStock());
			pstmt.setString(5, goods.getCategory());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DBConnection.close(conn);
	}
	
	// code로 상품 정보 조회
	public Goods selectGoods(String code) {
		Goods goods = null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from goods where code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if (rs!=null && rs.next()) {
				String rcode = rs.getString("code");
				String name = rs.getString(2);
				Integer price = rs.getInt(3);
				Integer stock = rs.getInt(4);
				String category = rs.getString(5);
				goods = new Goods(rcode, name, price, stock, category);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DBConnection.close(conn);
		return goods;
	}
	
	
}
