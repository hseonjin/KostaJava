package arrayTest;

public class ArrayTest5 {

	public static void main(String[] args) {
		// 다차원 배열의 선언과 생성
		int[][] narr2 = new int[][] { // new int[][] 생략 가능, 이 경우 배열의 크기 지정x
				{ 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		// 가변배열: 행 배열의 크기만 지정, 열 배열 크기 지정하지 않고 각각 다르게 저장 가능
		int[][] narr3 = new int[3][];
		// 또는
		// int[][] narr3;
		// narr3 = new int[3][4];
		narr3[0] = new int[] { 1, 2, 3, 4 };
		narr3[1] = new int[] { 5, 6, 7, 8 };
		narr3[2] = new int[] { 9, 10, 11, 12 };

		int[][] narr4 = new int[3][];
		narr4[0] = new int[] { 1, 2, 3, 4, 5 };
		narr4[1] = new int[] { 10, 20 };
		narr4[2] = new int[] { 100, 200, 300 };
	}

}
