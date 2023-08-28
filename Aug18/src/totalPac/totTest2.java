package totalPac;

import java.util.Scanner;

public class totTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sel = 0;
		int money = 0;
		int[] order = new int[10]; // �ֹ����
		int ordCnt = 0; // �ֹ�����
		int[] coins = { 5000, 1000, 500 };
		int[] price = { 1500, 2500, 2500, 2000, 3000 };
		String[] menu = { "�Ƹ޸�ī��", "ī���", "īǪġ��", "����������", "ī���ī" };

		while (true) {
			System.out.println("=====[�ڽ�Ÿ ī��]=====");
			for (int i = 0; i < menu.length; i++) {
				System.out.println(String.format("%d. %s(%d��)", i + 1, menu[i], price[i]));
			}
			System.out.println("0. ���");
			System.out.println("===================");
			System.out.println("����>");

			// �޴� �Է� �ޱ� (0: ����)
			sel = sc.nextInt();
			if (sel == 0) {
				int amount = 0;
				// 1. �ֹ����� �����ֱ�
				System.out.println("<�ֹ�����>");
				for (int i = 0; i < ordCnt; i++) {
					System.out.print(menu[order[i] - 1] + " ");
					amount += price[order[i] - 1];
				}
				System.out.println("��ü�ݾ�: " + amount);

				// 2. �� �Է¹ޱ�
				System.out.println("\n���� ��������>");
				money = sc.nextInt();

				// 3. ���� �����ϸ� '���� �����մϴ�.' ���
				if (money < amount) {
					System.out.println("���� �����մϴ�.");
				} else { // 4. ���� �������� ������ �ܵ� �����ֱ�
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