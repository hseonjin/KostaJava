package arrayPac;

public class ArrayTest5 {

	public static void main(String[] args) {
		// ������ �迭�� ����� ����
		int[][] narr2 = new int[][] { // new int[][] ���� ����, �� ��� �迭�� ũ�� ����x
				{ 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		// �����迭: �� �迭�� ũ�⸸ ����, �� �迭 ũ�� �������� �ʰ� ���� �ٸ��� ���� ����
		int[][] narr3 = new int[3][];
		// �Ǵ�
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
