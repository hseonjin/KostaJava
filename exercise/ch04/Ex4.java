package ch04;

public class Ex4 {

	public static void main(String[] args) {
		// 1
		int sum = 0, i;
		for (i = 1;; i++) {
			sum += (i % 2 == 0) ? -i : i;
			if (sum >= 100) break;
		}
		System.out.println("i:" + i + "\rsum:" + sum);
	}

}
