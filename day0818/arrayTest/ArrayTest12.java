package arrayTest;

import java.util.Scanner;

public class ArrayTest12 {

	public static void main(String[] args) {
		// �л� 3���� ����, ����, ���� ������ �Է¹޾� �л��� ������ ���� �հ踦 �Ʒ��� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

		// �Է�
		// <1��° �л��� ����>
		// ����:95
		// ����:100
		// ����:88
		// <2��° �л��� ����>
		// ����:85
		// ����:60
		// ����:93
		// <3��° �л��� ����>
		// ����:66
		// ����:99
		// ����:88

		// ���
		// ���� ���� ���� ����
		// 1��
		// 2��
		// 3��
		// ���
		Scanner sc = new Scanner(System.in);
		int[][] score = new int[4][4];
		// �л����� ���� �Է¹ޱ�
		for (int i = 0; i < score.length - 1; i++) {
			System.out.println(String.format("<%d��° �л��� ����>", i + 1));
			// ����, ����, ���� ������ �Է¹ޱ� (�� ���� �Է��ؾ� �ϱ� ������ j�� ���� ����ϴ� ����� ����)
			for (int j = 0; j < score.length - 1; j++) {
				if (j == 0)
					System.out.print("���� : ");
				else if (j == 1)
					System.out.print("���� : ");
				else
					System.out.print("���� : ");
				score[i][j] = sc.nextInt();
				score[i][score.length - 1] += score[i][j]; // �л��� �հ� ����
				score[score.length - 1][j] += score[i][j]; 
				// ���� ��� ���� ������ �Է��� ��� �ݿø� ���� ���� ���� ������ �� ����
			}
		}

		// �л����� ���� ����ϱ�
		System.out.println("\t����\t����\t����\t����");
		for (int i = 0; i < score.length; i++) {
			System.out.print((i + 1) + "��\t");
			for (int j = 0; j < score.length; j++) {
				if (i == score[i].length - 1) {
					if (j == score.length - 1)
						continue; // �� ������ 0�� ������� ����
					System.out.print(score[i][j] / 3 + "\t");
				} else
					System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
