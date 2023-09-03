package com.test06.entity;

public class Juice extends Drink{
	public final int JUICE_PRICE = 100;
	
	public Juice() {};
	
	@Override
	public String toString() {
		return "주스 \t" + JUICE_PRICE + "원";
	}
}
