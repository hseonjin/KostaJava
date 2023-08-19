package arrayTest;

public class ResetTest {

	public static void main(String[] args) {
		// 배열 초기화
		int[] score = new int[5];
		score[0] = 100;
		score[1] = 90;
		score[2] = 80;
		score[3] = 70;
		score[4] = 60;

		int[] score1 = { 100, 90, 80, 70, 60 };
		int[] score2 = new int[] {};

//		int[] score;
//		score = {100, 90, 80, 70, 60}; // 에러 발생
		int[] score3;
		score = new int[] { 100, 90, 80, 70, 60 }; // ok

//		int add(int[] arr) {100, 90, 80, 70, 60};
//		int result = add({100, 90, 80, 70, 60});
	}

}
