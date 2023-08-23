package companyElement;

public abstract class Employee {
	int id;
	String name;
	
	// getter,setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// 생성자
	public Employee(){}
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// method
	public String info() {
		return "사번: " + id + ", 이름: " + name;
	}
	
	// 자식 메서드를 한번에 불러 사용하기 위해 생성만 해줌
	public abstract int getPay();
	
}
