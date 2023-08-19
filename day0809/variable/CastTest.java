package variable;

public class CastTest {

	public static void main(String[] args) {
		byte bt = 10;
		int i = bt;

		byte bt2 = (byte) i;

		float f = i;
		int i2 = (int) f; // 소수점 잘림

		double d = f;
		float f2 = (float) d;
	}

}
