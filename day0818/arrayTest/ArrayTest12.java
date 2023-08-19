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
		String[] subject = { "����", "����", "����" };
		int[][] score = new int[4][4];

		// ���� �Է� �ޱ�
		for (int i = 0; i < score.length - 1; i++) {
			System.out.println("<" + (i + 1) + "��° �л��� ����>");
			for (int j = 0; j < score[i].length - 1; j++) {
				System.out.println(subject[j] + ":");
				score[i][j] = sc.nextInt();
				score[i][score[i].length - 1] += score[i][j]; // ������ ���� ����
				score[score.length - 1][j] += score[i][j]; // ������ �࿡ ����
			}
		}

		// ���� ���
		for (int i = 0; i < score[0].length - 1; i++) {
			score[score.length - 1][i] /= 3;
		}

		// �л��� ����
		System.out.println("\t����\t����\t����\t����");
		for (int i = 0; i < score.length; i++) {
			System.out.print(i + 1 + "��\t");
			for (int j = 0; j < score.length; j++) {
				if (score[i][j] != 0) {
					System.out.print(score[i][j]);
				}
				System.out.println("\t");
			}
			System.out.println();
		}
	}

}
