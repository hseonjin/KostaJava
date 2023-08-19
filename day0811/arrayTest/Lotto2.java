package arrayTest;

public class Lotto2 {

	public static void main(String[] args) {
		// 숫자 6개를 뽑는데 앞에 나왔던 숫자가 뽑히면 새로 뽑기
		int[] ball = new int[6];
		int cnt = 0;
		boolean same = false;

		while (true) {
			// 1~45 중 랜덤값 가져오기
			int rand = (int) (Math.random() * 45) + 1;

			// ball 배열에서 rand와 같은 값이 있는지 확인
			for (int i = 0; i < cnt; i++) {
				if (ball[i] == rand) {
					same = true;
					break;
				}
			}
			if (same == false) {
				ball[cnt++] = rand;
			}
			if (cnt == 6)
				break;
		}
		for (int i = 0; i < ball.length; i++) {
			System.out.print(ball[i] + ", ");
		}
	}

}
