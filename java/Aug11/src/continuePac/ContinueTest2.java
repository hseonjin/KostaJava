package continuePac;

public class ContinueTest2 {

	public static void main(String[] args) {
		// 4�� ����̰ų� 7�� ����� ��� ������ �ʱ�
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (!(i % 4 == 0 || i % 7 == 0))
				continue;
			sum += i;
		}
		System.out.println(sum);
	}

}
