package com.test06.entity;

public class Coke extends Drink{
	public final int COKE_PRICE = 100;
	
	public Coke() {};
	
	@Override
	public String toString() {
		return "주스 \t" + COKE_PRICE + "원";
	}
}
