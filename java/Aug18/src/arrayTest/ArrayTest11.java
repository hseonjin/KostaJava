package arrayTest;

import java.util.Scanner;

public class ArrayTest11 {

	public static void main(String[] args) {
		// 100 미만의 양의 정수들이 주어진다.
		// 입력받다가 0이 되면 마지막에 입력된 0을 제외하고
		// 그 때까지 입력된 정수의 십의 자리 숫자가 각각 몇 개인지
		// 작은 수부터 출력하는 프로그램을 작성하시오. (0개인 숫자는 출력하지 않음)
		// 입력: 10 55 3 63 85 61 85 0
		// 출력:
		// 0:1
		// 1:1
		// 5:1
		// 6:2
		// 8:2

		int[] cnt = new int[10]; // 십의 자리수 저장할 배열 생성
		int num = 0;

		Scanner sc = new Scanner(System.in);

		while (true) {
			num = sc.nextInt(); // 0이 입력될 때까지 반복

			// 입력값의 십의자리가 인덱스 번호와 일치할 때 ++
			// 마지막에 입력된 0을 제외
			for (int i = 0; i < cnt.length; i++) {
				if (num / 10 == i && num > 0) {
					cnt[i]++;
				}
			}

			if (num == 0) { // 입력값이 0이면 종료 -> 출력값 계산

				for (int i = 0; i < cnt.length; i++) {
					if (cnt[i] > 0) { // 해당하는 값이 있는 인덱스 번호만 출력
						System.out.println(i + " : " + cnt[i]);
					}
				}
				break;
			}
		}
	}
}
