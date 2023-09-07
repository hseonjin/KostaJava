package arrayPac;

public class ArrayTest7 {

	public static void main(String[] args) {
		// ���� ���հ� ���ϱ�
		int[][] narr = { { 10, 20, 30, 40 }, { 50, 60, 70, 80 }, { 90, 100, 110, 120 } };

		int[][] result = new int[narr.length + 1][narr[0].length + 1];

		for (int i = 0; i < narr.length; i++) { // ���� ������ŭ �ݺ�
			for (int j = 0; j < narr[i].length; j++) { // ���� ������ŭ �ݺ�
				// ���� �迭 ����
				result[i][j] = narr[i][j];
				// �� �հ�
				result[i][result[i].length - 1] += narr[i][j];
				// �� �հ�
				result[narr.length][j] += narr[i][j];
				// ��/�� ���հ�
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
