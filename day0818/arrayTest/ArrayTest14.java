package arrayTest;

import java.util.Scanner;

public class ArrayTest14 {

	public static void main(String[] args) {
		// �Է� ������ �� : 5
		// 95, 100, 85, 77, 60
		// ��� : 60, 75, 85, 95, 100
		Scanner sc = new Scanner(System.in);

		System.out.println("�Է� ������ ��: ");
		int arrSize = sc.nextInt();
		int[] arr = new int[arrSize];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		// ������
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				int temp;
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}

	}

}
