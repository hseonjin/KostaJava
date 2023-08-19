package continueTest;

public class ContinueTest2 {

	public static void main(String[] args) {
		// 4의 배수이거나 7의 배수인 경우 더하지 않기
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (!(i % 4 == 0 || i % 7 == 0))
				continue;
			sum += i;
		}
		System.out.println(sum);
	}

}
