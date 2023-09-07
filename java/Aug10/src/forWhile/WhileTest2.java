package forWhile;

public class WhileTest2 {

	public static void main(String[] args) {
		int dan, i = 1;
		for (i = 1; i <= 9; i++) {
			dan = 2;
			while (dan <= 9) {
				System.out.println(String.format("%d x %d = %2d\t", i, dan, dan * i));
				dan++;
			}
			i++;
			System.out.println();
		}
	}

}
