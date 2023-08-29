package ch04;

public class Ex8 {

	public static void main(String[] args) {
		int x = 1, y = 1;
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				if (2 * i + 4 * j == 10)
					System.out.println(String.format("x=%d, y=%d", i, j));
			}
		}

	}

}
