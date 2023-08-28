package totalPac;

import java.util.Scanner;

public class totTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sel = 0;
		int money = 0;
		int[] coins = { 5000, 1000, 500 };
		int[] price = { 1500, 2500, 2500, 2000, 3000 };

		while (true) {
			System.out.println("=====[�ڽ�Ÿ ī��]=====");
			System.out.println("1. �Ƹ޸�ī�� (1500��)");
			System.out.println("2. ī��� (2500��)");
			System.out.println("3. īǪġ�� (2500��)");
			System.out.println("4. ���������� (2000��)");
			System.out.println("5. ī���ī (3000��)");
			System.out.println("0. ����");
			System.out.println("===================");
			System.out.println("����>");
			
			// �޴� �Է� �ޱ� (0: ����)
			sel = sc.nextInt();
			if (sel == 0)
				break;
			
			// ���� ���� �޴� �ݾ� ��
			System.out.println("���� ��������>");
			money = sc.nextInt();
			if (money < price[sel - 1]) {
				System.out.println("���� �����մϴ�.");
				continue;
			}
			
			// �ܵ� ���
			int change = money - price[sel-1];
			System.out.print("�ܵ�: ");
			for (int i = 0; i < coins.length; i++) {
				int cnt = change/coins[i];
				if (cnt > 0) {
					System.out.print(String.format("%d��(%d��) ", coins[i], cnt));
				}
				change %= coins[i];
			}
			System.out.println("\n");
		}
	}
}

//		do {
//			System.out.println("[�ڽ�Ÿ ī��]");
//			System.out.println("1. �Ƹ޸�ī�� (1500��)");
//			System.out.println("2. ī��� (2500��)");
//			System.out.println("3. īǪġ�� (2500��)");
//			System.out.println("4. ���������� (2000��)");
//			System.out.println("5. ī���ī (3000��)");
//			System.out.println("0. ����");
//			System.out.println("����>");
//			sel = sc.nextInt();
//		} while (sel != 0);

// �Ա��� ���ݺ��� ���� ��� : "���� �����մϴ�." ���
// �Ա��� ���ݺ��� ū ��� : �ܵ�: 5000(1), 1000(0), 500(0)