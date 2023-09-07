package com.test05;

public class Secretary extends Employee implements Bonus {

	// 생성자
	public Secretary() {
	};

	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	};

	// 추상클래스 메소드 오버라이딩
	public double tax() { // 세금 (salary의 10% 징수)
		return getSalary() * 0.1;
	}

	// 인터페이스 메소드 오버라이딩
	@Override
	public void incentive(int pay) { // 인센티브 지급 (pay의 80%가 기존 월급에 더해짐)
		setSalary(getSalary() + (int) (pay * 0.8));
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%d", getName(), getDepartment(), getSalary());
	}
}
