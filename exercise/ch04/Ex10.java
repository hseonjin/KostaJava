package ch04;

public class Ex10 {

	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		
		while(true) {
			if (num == 0) break;
			sum += num % 10; // �������� ��� ���Ѵ� 5		4	  3	  2  1
			num /= 10; // ���� ����Ͽ� ���� ���� ���� 1234	123	  12  1  break
		}
		System.out.println("sum: " + sum);
	}

}
