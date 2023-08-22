package bankAndEx;

public class Company {

	Employee[] mem = new Employee[100];
	int memCnt; // 실제 개설된 계좌의 개수

	void enter(Employee emp) {
		mem[memCnt++] = emp;
	}

	void setBonus(int id, long bonus) {
		for(int i=0; i<memCnt; i++) {
			if(mem[i].id == id) {
				mem[i].pay += bonus; // 급여에 보너스를 더해줌
			}
		}
	}

	void allEmployeeInfo() {
		for (int i = 0; i < memCnt; i++) {
			System.out.println(mem[i].info());
		}
	}
	
	long getTotalPay() {
		long total = 0;
		for(int i=0; i<memCnt; i++) {
			total += mem[i].pay;
		}
		return total;
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
 * 총급여액:
 */
