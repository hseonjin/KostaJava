package ch05;

public class Ex11 {

	public static void main(String[] args) {
		int[][] score = {
				 {100, 100, 100}
				, {20, 20, 20}
				, {30, 30, 30}
				, {40, 40, 40}
				, {50, 50, 50}
		};
		
		int[][] result = new int[score.length + 1][score[0].length + 1];
		
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				// 배열 기존 값 복사
				result[i][j] = score[i][j];
				
				// 열(세로) 계산
				result[score.length][j] += score[i][j];
				
				// 행(가로) 계산
				result[i][score[i].length] += score[i][j];
				
				// 총합 계산
				result[score.length][score[i].length] += score[i][j];
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.printf("%4d", result[i][j]);
			}
			System.out.println();
		}
	}
}
