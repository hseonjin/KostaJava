package arrayTest;

public class Lotto1 {

	public static void main(String[] args) {
		// int type 45개 배열 선언
		int[] ball = new int[45];

		// 배열에 1~45까지의 값으로 초기화
		for (int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
		}

		// 1000번 반복
		for (int i = 0; i <= 1000; i++) {
			// 0~44 중 두 개의 임의의 정수를 구해 변수에 담기
			int idx1 = (int) (Math.random() * 45);
			int idx2 = (int) (Math.random() * 45);

			// idx1, idx2 값 바꾸기
			int temp = ball[idx1];
			ball[idx1] = ball[idx2];
			ball[idx2] = temp;
		}

		// 배열 중 숫자 6개 뽑기
		for (int i = 0; i < 6; i++) {
			System.out.println(ball[i] + ",");
		}
	}

}
