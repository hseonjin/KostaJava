package arrayTest;

import java.util.Scanner;

public class ArrayTest15 {

	public static void main(String[] args) {
		// �Է� ������ �� : 5
		// 95, 100, 85, 77, 60
		// ���
		// �ּҰ�: 60
		// �ִ밪: 100

		Scanner sc = new Scanner(System.in);

		System.out.println("�Է� ������ ��: ");
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
		System.out.println(String.format("�ּҰ�: %d\n�ִ밪: %d", min, max));
	}

}
