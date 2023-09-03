package com.test06.entity;

public class Drink {
	int price; // 잔액

	// getter, setter
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	// 생성자
	public Drink() {};
	public Drink(int price) {
		this.price = price;
	};
	
}
