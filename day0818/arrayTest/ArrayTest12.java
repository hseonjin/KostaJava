package arrayTest;

import java.util.Scanner;

public class ArrayTest12 {

	public static void main(String[] args) {
		// 학생 3명의 국어, 영어, 수학 점수를 입력받아 학생별 총점과 과목별 합계를 아래와 같이 출력하는 프로그램을 작성하시오.

		// 입력
		// <1번째 학생의 점수>
		// 국어:95
		// 영어:100
		// 수학:88
		// <2번째 학생의 점수>
		// 국어:85
		// 영어:60
		// 수학:93
		// <3번째 학생의 점수>
		// 국어:66
		// 영어:99
		// 수학:88

		// 출력
		// 국어 영어 수학 총점
		// 1번
		// 2번
		// 3번
		// 평균
		Scanner sc = new Scanner(System.in);
		String[] subject = { "국어", "영어", "수학" };
		int[][] score = new int[4][4];

		// 점수 입력 받기
		for (int i = 0; i < score.length - 1; i++) {
			System.out.println("<" + (i + 1) + "번째 학생의 점수>");
			for (int j = 0; j < score[i].length - 1; j++) {
				System.out.println(subject[j] + ":");
				score[i][j] = sc.nextInt();
				score[i][score[i].length - 1] += score[i][j]; // 마지막 열에 누적
				score[score.length - 1][j] += score[i][j]; // 마지막 행에 누적
			}
		}

		// 과목별 평균
		for (int i = 0; i < score[0].length - 1; i++) {
			score[score.length - 1][i] /= 3;
		}

		// 학생별 총점
		System.out.println("\t국어\t영어\t수학\t총점");
		for (int i = 0; i < score.length; i++) {
			System.out.print(i + 1 + "번\t");
			for (int j = 0; j < score.length; j++) {
				if (score[i][j] != 0) {
					System.out.print(score[i][j]);
				}
				System.out.println("\t");
			}
			System.out.println();
		}
	}

}
