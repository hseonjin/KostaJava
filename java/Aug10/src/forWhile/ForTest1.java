package forWhile;

public class ForTest1 {

	public static void main(String[] args) {
		// 1~100 �� ���ϱ�
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);

		// 1~100���� �� ¦���� �� ���ϱ�
		int sum1 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0)
				sum1 += i;
		}
		System.out.println(sum1);
	}

}