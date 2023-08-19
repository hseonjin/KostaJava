package forWhile;

public class WhileTest3 {

	public static void main(String[] args) {
		int sum = 0, i = 0;
		while (sum <= 100) {
			i++;
			sum += i;
		}
		System.out.println(sum);
		System.out.println(i);
	}

}
