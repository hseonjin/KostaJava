package ch04;

public class Ex1 {

	public static void main(String[] args) {
		// 1. int�� ���� x�� 10���� ũ�� 20���� ���� �� true�� ���ǽ�
		int x = 12;
		if (x > 10 && x < 20) {};

		// 2. char�� ���� ch�� �����̳� ���� �ƴ� �� true�� ���ǽ�
		char ch = 'a';
		if (ch != ' ' && ch != '\t') {};

		// 3. char�� ���� ch�� ��x' �Ǵ� ��X'�� �� true�� ���ǽ�
		if (ch == 'x' || ch == 'X') {};

		// 4. char�� ���� ch�� ����(��0��~��9��)�� �� true�� ���ǽ�
		if (ch >= 0 && ch <= 9) {};

		// 5. char�� ���� ch�� ������(�빮�� �Ǵ� �ҹ���)�� �� true�� ���ǽ�
		if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {};

		// 6. int�� ���� year�� 400���� �����������ų� 4�� ������������ 100���� ���������������� �� true�� ���ǽ�
		int year = 2023;
		if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {};

		// 7. boolean�� ���� powerOn�� false�� �� true�� ���ǽ�
		boolean powerOn = false;
		if (!powerOn) {};

		// 8. ���ڿ� �������� str�� ��yes���� �� true�� ���ǽ�
		String str = "yse";
		if (str.equals("yes")) {};
	}

}
