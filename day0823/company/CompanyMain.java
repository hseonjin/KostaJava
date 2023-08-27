package company;

import companyElement.Employee;
import companyElement.PartTime;
import companyElement.Permanent;
import companyElement.Sales;

public class CompanyMain {
	// 각부서의 정보를 담을 배열 생성
	static Employee[] emps = new Employee[100];
	static int empCnt = 0;

	// permanent, sales, partTime을 모두 담을 수 있는 타입은 Employee
	// upcasting
	public static void enter(Employee emp) {
		emps[empCnt++] = emp;
	}

	public static void allEmployeeInfo() {
		for (int i = 0; i < empCnt; i++) {
			System.out.println(emps[i].info()); // Employee의 info
		}
	}

	public static int getTotalPay() {
		int tot = 0;
		for (int i = 0; i < empCnt; i++) {
			tot += emps[i].getPay();
		}
		return tot;
	}

	public static void regBusinessTrip() {
	};

	public static void main(String[] args) {
		Company com = new Company();
		Permanent emp1 = new Permanent(1001, "상부상조", 5000000);
		Sales emp2 = new Sales(1002, "자바조", 4000000, 1000000);
		PartTime emp3 = new PartTime(1003, "커피조", 160, 300000);

		// com.enter(emp1);
		com.enter(emp1);
		com.enter(emp2);
		com.enter(emp3);

		com.allEmployeeInfo();
		System.out.println("총급여액:" + com.getTotalPay());

//		com.regBusinessTrip(emp1, 1); // error, Permanent 출장 불가능
//		com.regBusinessTrip(emp2, 2); // Sales 출장 가능, 하루당 3000000원 insentive 지급
//		com.regBusinessTrip(emp3, 1); // PartTime 출장 가능, (출장시간(24H/1D)*payPerTime)원 insentive 지급

	}
}

/*
 * 사번: 1001, 이름: 상부상조, 급여: 5000000 사번: 1002, 이름: 자바조, 급여: 5000000 사번: 1003, 이름:
 * 커피조, 급여: 48000000
 */