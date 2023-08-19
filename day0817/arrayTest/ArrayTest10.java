package arrayTest;

public class ArrayTest10 {

	public static void main(String[] args) {
		// deep copy2
		int[] sarr = { 1, 2, 3, 4, 5 };
		int[] darr = sarr.clone(); // 배열을 생성하여 값을 복사하여 리턴해줌(복제)
		sarr[0] = 100;

		for (int i = 0; i < sarr.length; i++) {
			System.out.print(sarr[i] + ",");
		}

		System.out.println();

		for (int i = 0; i < darr.length; i++) {
			System.out.print(darr[i] + ",");
		}
	}

}
