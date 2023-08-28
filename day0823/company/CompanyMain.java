package company;

import companyElement.PartTime;
import companyElement.Permanent;
import companyElement.Sales;

public class CompanyMain {
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

		// 출장
//		com.regBusinessTrip(emp1, 1); // error, Permanent 출장 불가능
//		com.regBusinessTrip(emp2, 2); // Sales 출장 가능, 하루당 3000000원 insentive 지급
//		com.regBusinessTrip(emp3, 1); // PartTime 출장 가능, (출장시간(24H/1D)*payPerTime)원 insentive 지급

		com.allEmployeeInfo();
		System.out.println("총 급여: " + com.getTotalPay());
	}
}

/*
 * 사번: 1001, 이름: 상부상조, 급여: 5000000 
 * 사번: 1002, 이름: 자바조, 급여: 5000000 
 * 사번: 1003, 이름: 커피조, 급여: 48000000
 */