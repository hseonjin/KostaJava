package forWhile;

public class ForTest3 {

	public static void main(String[] args) {
		int num;
		for (num = 1; num <= 9; num++) {
			for (int i = 2; i <= 9; i++) {
				System.out.print(String.format("%dx%d=%d\t", i, num, num * i));
			}
			System.out.println();
		}
	}
}