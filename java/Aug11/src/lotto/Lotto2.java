package lotto;

public class Lotto2 {

	public static void main(String[] args) {
		// ���� 6���� �̴µ� �տ� ���Դ� ���ڰ� ������ ���� �̱�
		int[] ball = new int[6];
		int cnt = 0;
		boolean same = false;

		while (true) {
			// 1~45 �� ������ ��������
			int rand = (int) (Math.random() * 45) + 1;

			// ball �迭���� rand�� ���� ���� �ִ��� Ȯ��
			for (int i = 0; i < cnt; i++) {
				if (ball[i] == rand) {
					same = true;
					break;
				}
			}
			if (same == false) {
				ball[cnt++] = rand;
			}
			if (cnt == 6)
				break;
		}
		for (int i = 0; i < ball.length; i++) {
			System.out.print(ball[i] + ", ");
		}
	}

}
