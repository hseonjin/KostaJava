package com.test04;

public class Cargoplane extends Plane{
	// 생성자
	Cargoplane(){}
	Cargoplane(String planeName, int fuelSize){
		super(planeName, fuelSize);
	}
	
	// 메소드 오버라이딩
	@Override
	public void flight(int distance) { // 10 운항시 연료 50 감소
		setFuelSize(this.getFuelSize() - (distance/10) * 50);
	}
}
