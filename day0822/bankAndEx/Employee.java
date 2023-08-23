package bankAndEx;

public class Employee {
	int id;
	String name;
	String dept;
	long salary;
	long bonus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Employee() {}
	public Employee(int id, String name, String dept, long salary){
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	// bonus
	public void payBonus(long money) {
		this.bonus += money;
	}
	
	public String info() {
		return "사번:"+id+",이름:"+name+",부서:"+dept+",급여:"+getPay();
	}
	
	public long getPay() {
		return salary + bonus;
	}
}
