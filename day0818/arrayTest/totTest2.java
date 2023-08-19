package arrayTest;

import java.util.Scanner;

public class totTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sel = 0;
		int money = 0;
		int[] order = new int[10]; // 주문목록
		int ordCnt = 0; // 주문개수
		int[] coins = { 5000, 1000, 500 };
		int[] price = { 1500, 2500, 2500, 2000, 3000 };
		String[] menu = { "아메리카노", "카페라떼", "카푸치노", "에스프레소", "카페모카" };

		while (true) {
			System.out.println("=====[코스타 카페]=====");
			for (int i = 0; i < menu.length; i++) {
				System.out.println(String.format("%d. %s(%d원)", i + 1, menu[i], price[i]));
			}
			System.out.println("0. 계산");
			System.out.println("===================");
			System.out.println("선택>");

			// 메뉴 입력 받기 (0: 종료)
			sel = sc.nextInt();
			if (sel == 0) {
				int amount = 0;
				// 1. 주문내역 보여주기
				System.out.println("<주문내역>");
				for (int i = 0; i < ordCnt; i++) {
					System.out.print(menu[order[i] - 1] + " ");
					amount += price[order[i] - 1];
				}
				System.out.println("전체금액: " + amount);

				// 2. 돈 입력받기
				System.out.println("\n돈을 넣으세요>");
				money = sc.nextInt();

				// 3. 돈이 부족하면 '돈이 부족합니다.' 출력
				if (money < amount) {
					System.out.println("돈이 부족합니다.");
				} else { // 4. 돈이 부족하지 않으면 잔돈 내어주기
					int change = money - amount;
					for (int i = 0; i < coins.length; i++) {
						if (change / coins[i] != 0) {
							System.out.print(String.format("%d(%d) ", coins[i], change / coins[i]));
						}
						change %= coins[i];
					}
				}
				break;
			}
			order[ordCnt++] = sel;
		}
	}
}