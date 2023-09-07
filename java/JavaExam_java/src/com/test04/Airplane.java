package com.test04;

public class Airplane extends Plane{
	// 생성자
	public Airplane(){}
	public Airplane(String planeName, int fuelSize){
		super(planeName, fuelSize);
	}
	
	
	// 메소드 오버라이딩
	@Override
	public void flight(int distance) { // 10 운항시 연료 30 감소
		setFuelSize(this.getFuelSize() - (distance/10) * 30);
	}
	

	
}
