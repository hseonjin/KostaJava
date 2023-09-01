package com.test02;

public class Human {
	// 필드
	protected String name;
	protected int age;
	protected int height;
	protected int weight;

	// 생성자
	public Human(){}
	public Human(String name, int age, int height, int weight){
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	// 메소드 - Human 정보 리턴
	public String toString() {
		return name + " " + age + " " + height + " " + weight;
	}
	
}
