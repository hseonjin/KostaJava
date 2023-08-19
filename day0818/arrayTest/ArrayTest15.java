package arrayTest;

import java.util.Scanner;

public class ArrayTest15 {

	public static void main(String[] args) {
		// 입력 데이터 수 : 5
		// 95, 100, 85, 77, 60
		// 출력
		// 최소값: 60
		// 최대값: 100

		Scanner sc = new Scanner(System.in);

		System.out.println("입력 데이터 수: ");
		int arrSize = sc.nextInt();
		int[] arr = new int[arrSize];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int max = arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		System.out.println(String.format("최소값: %d\n최대값: %d", min, max));
	}

}
