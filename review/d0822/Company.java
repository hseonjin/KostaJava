package d0822;

class Employee {
	int id;
	String name;
	String dept;
	int salary;
	int bonus;
	
	Employee (int id, String name, String dept, int salary) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	
	String meminfo() {
		return String.format("사번: %d, 이름: %s, 부서: %s, 급여: %d", id, name, dept, salary);
	}
}

public class Company {
	Employee[] memInfo = new Employee[100];
	int memCnt;
	
	// 사원 등록
	void enter(Employee emp) {
		memInfo[memCnt++] = emp;
	}
	
	// 보너스 지급 (salary에 더하기)
	void setBonus(int id, int bonus) {
		for(int i=0; i<memCnt; i++) {
			if(memInfo[i].id == id) {
				memInfo[i].salary += bonus;
			}
		}
	}
	
	// 모든 사원 정보 출력
	void allEmployeeInfo() {
		for(int i=0; i<memCnt; i++) {
			System.out.println(memInfo[i].meminfo());
		}
	}
	
	// 총급여액 출력하기
	int getTotalPay() {
		int totalPay = 0;
		for(int i=0; i<memCnt; i++) {
			totalPay += memInfo[i].salary;
		}
		return totalPay;
	}

	public static void main(String[] args) {
		Company com = new Company();

		Employee emp1 = new Employee(10001, "홍길동", "홍보부", 5000000);
		Employee emp2 = new Employee(10002, "고길동", "총무부", 3500000);
		Employee emp3 = new Employee(10003, "하길동", "개발부", 4000000);

		com.enter(emp1);
		com.enter(emp2);
		com.enter(emp3);
		com.setBonus(10001, 1000000);

		com.allEmployeeInfo();
		System.out.println("총급여액: " + com.getTotalPay());
	}
}

/*
 * 사번: 10001, 이름: 홍길동, 부서: 홍보부, 급여: 6000000 
 * 사번: 10002, 이름: 고길동, 부서: 총무부, 급여: 3500000 
 * 사번: 10003, 이름: 하길동, 부서: 개발부, 급여: 4000000 
 * 총급여액: 13500000
 */
