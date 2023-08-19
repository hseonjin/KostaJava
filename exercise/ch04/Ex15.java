package ch04;

public class Ex15 {

	public static void main(String[] args) {
		int number = 12321;
		int temp = number;

		int result = 0; // number을 거꾸로 변환하여 담을 변수

		while (temp != 0) {
			result = result * 10 + temp % 10;
			temp /= 10;
		}

		if (number == result)
			System.out.println(number + "는 회문수 입니다.");
		else
			System.out.println(number + "는 회문수가 아닙니다.");
	}

}
