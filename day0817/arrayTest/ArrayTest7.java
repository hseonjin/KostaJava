package arrayTest;

public class ArrayTest7 {

	public static void main(String[] args) {
		// 행의 총합계 구하기
		int[][] narr = { { 10, 20, 30, 40 }, { 50, 60, 70, 80 }, { 90, 100, 110, 120 } };

		int[][] result = new int[narr.length + 1][narr[0].length + 1];

		for (int i = 0; i < narr.length; i++) { // 행의 개수만큼 반복
			for (int j = 0; j < narr[i].length; j++) { // 열의 개수만큼 반복
				// 기존 배열 복사
				result[i][j] = narr[i][j];
				// 열 합계
				result[i][result[i].length - 1] += narr[i][j];
				// 행 합계
				result[narr.length][j] += narr[i][j];
				// 행/열 총합계
				result[narr.length][narr[i].length] += narr[i][j];
			}
		}

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
