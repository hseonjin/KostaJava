package lotto;

public class Lotto1 {

	public static void main(String[] args) {
		// int type 45�� �迭 ����
		int[] ball = new int[45];

		// �迭�� 1~45������ ������ �ʱ�ȭ
		for (int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
		}

		// 1000�� �ݺ�
		for (int i = 0; i <= 1000; i++) {
			// 0~44 �� �� ���� ������ ������ ���� ������ ���
			int idx1 = (int) (Math.random() * 45);
			int idx2 = (int) (Math.random() * 45);

			// idx1, idx2 �� �ٲٱ�
			int temp = ball[idx1];
			ball[idx1] = ball[idx2];
			ball[idx2] = temp;
		}

		// �迭 �� ���� 6�� �̱�
		for (int i = 0; i < 6; i++) {
			System.out.println(ball[i] + ",");
		}
	}

}
