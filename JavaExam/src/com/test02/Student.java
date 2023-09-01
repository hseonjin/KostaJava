package com.test02;

public class Student extends Human{
	// 필드
	private String number;
	private String major;
	
	// 생성자
	public Student(){}
	public Student(String name, int age, int height, int weight, String number, String major){
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + number + " " + major;
	}

}
