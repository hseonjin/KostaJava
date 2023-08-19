package forWhile;

public class ForTest1 {

	public static void main(String[] args) {
		// 1~100 합 구하기
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);

		// 1~100까지 중 짝수의 합 구하기
		int sum1 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0)
				sum1 += i;
		}
		System.out.println(sum1);
	}

}
