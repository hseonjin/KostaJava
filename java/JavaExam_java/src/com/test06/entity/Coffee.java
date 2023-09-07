package com.test06.entity;

public class Coffee extends Drink {
	public final int COFFEE_PRICE = 100;
	
	public Coffee() {};
	
	@Override
	public String toString() {
		return "커피 \t" + COFFEE_PRICE + "원";
	}
}
