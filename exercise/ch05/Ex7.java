package ch05;

import java.util.Scanner;

public class Ex7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�Ž�����: ");
		int money = sc.nextInt();

		System.out.println("money= " + money);
		int[] coinUnit = { 500, 100, 50, 10 };
		int[] coin = { 5, 5, 5, 5 };

		for (int i = 0; i < coinUnit.length; i++) {
			int coinNum = 0;
			// �ݾ�(money)�� ���������� ������ �ʿ��� ������ ����(coinNum)�� ���Ѵ�.
			// �迭 coin���� coinNum��ŭ�� ������ ����. (���� ����� ������ ���ٸ� �迭 coin�� �ִ� ��ŭ�� ����.)
			coinNum = (money / coinUnit[i] < coin[i]) ? money/coinUnit[i] : coin[i];
			coin[i] -= coinNum;
			// �ݾ׿��� ������ ����(coinNum)�� ���������� ���� ���� ����.
			money -= coinNum * coinUnit[i];

			System.out.println(coinUnit[i] + "��: " + coinNum);
		}

		if (money > 0) {
			System.out.println("�Ž������� �����մϴ�.");
			System.exit(0); // ���α׷��� �����Ѵ�.
		}
		System.out.println("=���� ������ ���� =");
		for (int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "��:" + coin[i]);
		}
	}
}