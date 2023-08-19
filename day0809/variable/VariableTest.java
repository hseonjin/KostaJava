package variable;

public class VariableTest {

	public static void main(String[] args) {
		char ch = 'A';
		char up7;
		up7 = '7';
		ch = 'B';
		System.out.println(ch);
		byte b = 127; // -128 ~ 127
		int i = 10;
		float f = 1.25f;
		double d = 3.14;
		boolean bool = true;
		String name = "Heo";

		// final 한 번 지정하면 변경할 수 없음
		final double pi = 3.14;

		// pi = 2.1;
		// 정수형은 int, 실수형은 double이 기본형이 됨.
	}

}
