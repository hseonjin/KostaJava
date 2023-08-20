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
		int[][] score = new int[4][4];
		// 학생들의 점수 입력받기
		for (int i = 0; i < score.length - 1; i++) {
			System.out.println(String.format("<%d번째 학생의 점수>", i + 1));
			// 국어, 영어, 수학 순으로 입력받기 (한 번에 입력해야 하기 때문에 j에 따라 출력하는 과목명 설정)
			for (int j = 0; j < score.length - 1; j++) {
				if (j == 0)
					System.out.print("국어 : ");
				else if (j == 1)
					System.out.print("영어 : ");
				else
					System.out.print("수학 : ");
				score[i][j] = sc.nextInt();
				score[i][score.length - 1] += score[i][j]; // 학생별 합계 저장
				score[score.length - 1][j] += score[i][j]; 
				// 과목별 평균 먼저 나눠서 입력할 경우 반올림 수에 따라서 값이 변동될 수 있음
			}
		}

		// 학생들의 점수 출력하기
		System.out.println("\t국어\t영어\t수학\t총점");
		for (int i = 0; i < score.length; i++) {
			System.out.print((i + 1) + "번\t");
			for (int j = 0; j < score.length; j++) {
				if (i == score[i].length - 1) {
					if (j == score.length - 1)
						continue; // 맨 마지막 0은 출력하지 않음
					System.out.print(score[i][j] / 3 + "\t");
				} else
					System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
