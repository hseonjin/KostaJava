package forWhile;

public class ForTest4 {

	public static void main(String[] args) {
		// ���ٷ� �����
		int cnt = 5;
		for (int i = 0; i < cnt; i++) {
			System.out.println("*");
		}

		// �簢������ �����
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// �Ѱ��� �����ϴ� �����
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// �Ѱ��� �����ϴ� �����
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
