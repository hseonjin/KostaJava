package arrayTest;

public class ArrayTest8 {

	public static void main(String[] args) {
		// 배열 복사
		int[] narr1 = { 1, 2, 3, 4 };

		int[] narr2 = new int[4];
//		narr2 = narr1; // new 관계가 끊어지고 narr1의 주소값을 복사하게 됨 (얕은 복사-shallow copy)

//		int[] narr2 = narr1; // narr1의 주소값을 복사하는 것 -> narr2(레퍼런스)의 값을 바꾸면 narr1(원본)도 같이 변함

		System.arraycopy(narr1, 0, narr2, 0, narr1.length); // 깊은복사-deep copy

		narr2[0] = 100;

		for (int i = 0; i < narr1.length; i++) {
			System.out.print(narr1[i] + ",");
		}

		System.out.println();

		for (int i = 0; i < narr2.length; i++) {
			System.out.print(narr2[i] + ",");
		}
	}

}
