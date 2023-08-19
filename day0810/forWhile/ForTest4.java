package forWhile;

public class ForTest4 {

	public static void main(String[] args) {
		// 한줄로 별찍기
		int cnt = 5;
		for (int i = 0; i < cnt; i++) {
			System.out.println("*");
		}

		// 사각형으로 별찍기
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 한개씩 증가하는 별찍기
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 한개씩 감소하는 별찍기
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
