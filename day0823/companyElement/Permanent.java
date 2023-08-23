package companyElement;

public class Permanent extends Employee {
	int salary;
	
	// getter,setter
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	// 생성자
	public Permanent() {}
	public Permanent(int id, String name, int salary) {
		super(id, name);
		this.salary = salary;
	}
	
	// method
	public int getPay() {
		return getSalary();
	}
	
	@Override
	public String info() {
		return super.info() + ", 급여: " + getPay();
	}
	
}
