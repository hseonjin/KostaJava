package com.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kosta.product.Goods;

public class GoodsDAO {
	public int insertGoods(Goods goods) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "insert into goods values(?,?,?,?,?)";
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
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		DBConnection.close(conn);
		return cnt;
	}
	
	public Goods selectGoods(String pCode) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Goods goods = null;
		String sql = "select * from goods where code=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pCode);
			rs=pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				goods = new Goods(rs.getString("code"),
							rs.getString("name"),
							rs.getInt("price"),
							rs.getInt("stock"),
							rs.getString("category"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		DBConnection.close(conn);
		return goods;
	}
}
