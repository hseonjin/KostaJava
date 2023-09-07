package com.test04;

public class PlaneTest {
	public static void main(String[] args) {
		// Airplane과 Cargoplane 객체생성
		Airplane airPlane = new Airplane("L777", 1000);
		Cargoplane cargoPlane = new Cargoplane("C50", 1000);
		
		// 생성된 객체의 정보 출력
		System.out.println("Plane fuelSize");
		System.out.println("---------------");
		System.out.println(airPlane.toString());
		System.out.println(cargoPlane.toString());
		System.out.println("100 운항");
		System.out.println();
		
		// Airplane과 Cargoplane 객체에 100씩 운항
		// 운항후 객체의 변경된 정보 출력
		airPlane.flight(100);
		cargoPlane.flight(100);
		
		System.out.println("Plane fuelSize");
		System.out.println("---------------");
		System.out.println(airPlane.toString());
		System.out.println(cargoPlane.toString());
		System.out.println("200 주유");
		System.out.println();
		
		// Airplane과 Cargoplane 객체에 200씩 주유
		// 주유후 객체의 변경된 정보 출력
		airPlane.refuel(200);
		cargoPlane.refuel(200);

		System.out.println("Plane fuelSize");
		System.out.println("---------------");
		System.out.println(airPlane.toString());
		System.out.println(cargoPlane.toString());
	}
}
