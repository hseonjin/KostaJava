package arrayTest;

import java.util.Scanner;

public class ArrayTest11 {

	public static void main(String[] args) {
		// 100 �̸��� ���� �������� �־�����.
		// �Է¹޴ٰ� 0�� �Ǹ� �������� �Էµ� 0�� �����ϰ�
		// �� ������ �Էµ� ������ ���� �ڸ� ���ڰ� ���� �� ������
		// ���� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�. (0���� ���ڴ� ������� ����)
		// �Է�: 10 55 3 63 85 61 85 0
		// ���:
		// 0:1
		// 1:1
		// 5:1
		// 6:2
		// 8:2

		int[] cnt = new int[10]; // ���� �ڸ��� ������ �迭 ����
		int num = 0;

		Scanner sc = new Scanner(System.in);

		while (true) {
			num = sc.nextInt(); // 0�� �Էµ� ������ �ݺ�

			// �Է°��� �����ڸ��� �ε��� ��ȣ�� ��ġ�� �� ++
			// �������� �Էµ� 0�� ����
			for (int i = 0; i < cnt.length; i++) {
				if (num / 10 == i && num > 0) {
					cnt[i]++;
				}
			}

			if (num == 0) { // �Է°��� 0�̸� ���� -> ��°� ���

				for (int i = 0; i < cnt.length; i++) {
					if (cnt[i] > 0) { // �ش��ϴ� ���� �ִ� �ε��� ��ȣ�� ���
						System.out.println(i + " : " + cnt[i]);
					}
				}
				break;
			}
		}
	}
}
