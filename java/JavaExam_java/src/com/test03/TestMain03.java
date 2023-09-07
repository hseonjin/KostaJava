package com.test03;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.test02.Student;

public class TestMain03 {
	public static void main(String[] args) {
		String str = "1.22,4.12,5.93,8.71,9.34";

		// StringTokenizer 이용하여 List에 저장한다.
		StringTokenizer st = new StringTokenizer(str, ",");
		List<String> list = new ArrayList<String>();

		while (st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
			list.add(st.nextToken());
		}

		// List에 저장된 데이터의 합과 평균을 구한다.
		// 소수점 3자리 표현
		double total = 0;
		for (String li : list) {
			total += Double.parseDouble(li);
		}
		
		double avg = total / list.size();
		
		System.out.printf("합계 : %.3f\n", total);
		System.out.printf("평균 : %.3f", avg);
	}
}
