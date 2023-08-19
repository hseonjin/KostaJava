package ex;

public class LandomTest {

	public static void main(String[] args) {
		// 1~45까지 숫자 중 랜덤으로 뽑기
		// 0.0 <= Math.random() < 1.0
		// 0.0 * 45 <= Math.random() * 45 < 1.0 * 45
		// 0.0 <= (int)(Math.random() * 45) < 45.0
		int ball = (int) (Math.random() * 45) + 1;
		System.out.println(ball);
	}

}
