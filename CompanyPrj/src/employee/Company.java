package employee;

public class Company {
	Employee[] emps = new Employee[100];
	int empCnt;

	public void enter(Employee emp) { 
		emps[empCnt++] = emp;
	}

	// 전체 사원 조회
	public void allEmployeeInfo() {
		for (int i = 0; i < empCnt; i++) {
			System.out.println(emps[i].toString());
		}
	}

	// 총 급여
	public int getTotalPay() {
		int total = 0;
		for (int i = 0; i < empCnt; i++) {
			total += emps[i].getPay();
		}
		return total;
	}

	// 출장을 넣어주는 기능
	public void regBusinessTrip(BusinessTrip emp, int day) {
		emp.regBusinessTrip(day);
	}
}