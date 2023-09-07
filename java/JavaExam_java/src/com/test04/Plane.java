package com.test04;

public abstract class Plane {
	// 필드
	private String planeName;
	private int fuelSize;
	
	public String getPlaneName() {
		return planeName;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public int getFuelSize() {
		return fuelSize;
	}
	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
	// 생성자
	public Plane() {}
	public Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
	// 메소드
	public void refuel(int fuel) { // 주유 (일정량 연료 주입, 기존 연료 증가됨)
		fuelSize += fuel;
	}
	
	// 추상 메소드
	public abstract void flight(int distance); // 운항 (일정거리만큼 운항, 연료 감소)
	
	public String toString() {
		return planeName + " " + fuelSize;
	};

}
