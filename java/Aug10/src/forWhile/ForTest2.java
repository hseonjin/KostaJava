package forWhile;

public class ForTest2 {

	public static void main(String[] args) {
		int dan;
		for (dan = 2; dan <= 9; dan++) {
			System.out.println(dan + "단");
			for (int i = 1; i <= 9; i++) {
				System.out.println(String.format("%dx%d = %d", dan, i, dan * i));
			}
			System.out.println();
		}
	}

}
