package arrayTest;

import java.util.Scanner;

public class totTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sel = 0;
		int money = 0;
		int[] coins = { 5000, 1000, 500 };
		int[] price = { 1500, 2500, 2500, 2000, 3000 };

		while (true) {
			System.out.println("=====[코스타 카페]=====");
			System.out.println("1. 아메리카노 (1500원)");
			System.out.println("2. 카페라떼 (2500원)");
			System.out.println("3. 카푸치노 (2500원)");
			System.out.println("4. 에스프레소 (2000원)");
			System.out.println("5. 카페모카 (3000원)");
			System.out.println("0. 종료");
			System.out.println("===================");
			System.out.println("선택>");
			
			// 메뉴 입력 받기 (0: 종료)
			sel = sc.nextInt();
			if (sel == 0)
				break;
			
			// 받은 돈과 메뉴 금액 비교
			System.out.println("돈을 넣으세요>");
			money = sc.nextInt();
			if (money < price[sel - 1]) {
				System.out.println("돈이 부족합니다.");
				continue;
			}
			
			// 잔돈 계산
			int change = money - price[sel-1];
			System.out.print("잔돈: ");
			for (int i = 0; i < coins.length; i++) {
				int cnt = change/coins[i];
				if (cnt > 0) {
					System.out.print(String.format("%d원(%d개) ", coins[i], cnt));
				}
				change %= coins[i];
			}
			System.out.println("\n");
		}
	}
}

//		do {
//			System.out.println("[코스타 카페]");
//			System.out.println("1. 아메리카노 (1500원)");
//			System.out.println("2. 카페라떼 (2500원)");
//			System.out.println("3. 카푸치노 (2500원)");
//			System.out.println("4. 에스프레소 (2000원)");
//			System.out.println("5. 카페모카 (3000원)");
//			System.out.println("0. 종료");
//			System.out.println("선택>");
//			sel = sc.nextInt();
//		} while (sel != 0);

// 입금이 가격보다 작을 경우 : "돈이 부족합니다." 출력
// 입금이 가격보다 큰 경우 : 잔돈: 5000(1), 1000(0), 500(0)