package arrayTest;

import java.util.Scanner;

public class ArrayTest16 {

	public static void main(String[] args) {
		// 파스칼 삼각형
		// 행렬 크기: 7
		// 1
		// 1 1
		// 1 2 1
		// 1 3 3 1
		// 1 4 6 4 1
		// 1 5 10 10 5 1
		// 1 6 15 20 15 6 1

		Scanner sc = new Scanner(System.in);
		System.out.println("행렬 크기: ");
		int size = sc.nextInt();
		int[][] matrix = new int[size][size];

		for (int i = 0; i < size; i++) {
			matrix[i][i] = 1;
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				matrix[i][j] = matrix[i - 1][j];
				if (j > 0)
					matrix[i][j] += matrix[i - 1][j - 1];
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= i; j++) {

				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
