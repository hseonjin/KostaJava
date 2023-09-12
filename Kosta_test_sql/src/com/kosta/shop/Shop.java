package com.kosta.shop;

import com.kosta.dao.GoodsDAO;
import com.kosta.dao.OrderDAO;
import com.kosta.order.Order;
import com.kosta.product.Goods;

public class Shop {
	// 구현해야 하는 부분: ApplicationMain.java 오류 없이 작동하도록 필요한 모든 메서드를 구현한다.

	private GoodsDAO goodsDAO;
	private OrderDAO orderDAO;

	public Shop() {
		goodsDAO = new GoodsDAO();
		orderDAO = new OrderDAO();
	}
	
	// 상품 추가
	public void addProduct(Goods goods) {
		goodsDAO.insertGoods(goods);
	}
	
	public void order(Order order) {
		orderDAO.insertOrder(order);
	}
	
	public Goods findProductByCode(String code) {
		Goods goods = goodsDAO.selectGoods(code);
		return goods;
	}
}
