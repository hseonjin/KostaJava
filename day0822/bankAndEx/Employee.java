package bankAndEx;

public class Employee {
	int id;
	String name;
	String dept;
	long pay;
	long total;
	
	Employee(int id, String name, String dept, long pay){
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.pay = pay;
	}
	
	String info() {
		return String.format("사번: %d, 이름: %s, 부서: %s, 급여: %d", id, name, dept, pay);
	}
}
