package ch04;

public class Ex15 {

	public static void main(String[] args) {
		int number = 12321;
		int temp = number;

		int result = 0; // number�� �Ųٷ� ��ȯ�Ͽ� ���� ����

		while (temp != 0) {
			result = result * 10 + temp % 10;
			temp /= 10;
		}

		if (number == result)
			System.out.println(number + "�� ȸ���� �Դϴ�.");
		else
			System.out.println(number + "�� ȸ������ �ƴմϴ�.");
	}

}
