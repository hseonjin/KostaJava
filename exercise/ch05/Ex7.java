package ch05;

import java.util.Scanner;

public class Ex7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("거스름돈: ");
		int money = sc.nextInt();

		System.out.println("money= " + money);
		int[] coinUnit = { 500, 100, 50, 10 };
		int[] coin = { 5, 5, 5, 5 };

		for (int i = 0; i < coinUnit.length; i++) {
			int coinNum = 0;
			// 금액(money)을 동전단위로 나눠서 필요한 동전의 개수(coinNum)를 구한다.
			// 배열 coin에서 coinNum만큼의 동전을 뺀다. (만일 충분한 동전이 없다면 배열 coin에 있는 만큼만 뺀다.)
			coinNum = (money / coinUnit[i] < coin[i]) ? money/coinUnit[i] : coin[i];
			coin[i] -= coinNum;
			// 금액에서 동전의 개수(coinNum)와 동전단위를 곱한 값을 뺀다.
			money -= coinNum * coinUnit[i];

			System.out.println(coinUnit[i] + "원: " + coinNum);
		}

		if (money > 0) {
			System.out.println("거스름돈이 부족합니다.");
			System.exit(0); // 프로그램을 종료한다.
		}
		System.out.println("=남은 동전의 개수 =");
		for (int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "원:" + coin[i]);
		}
	}
}