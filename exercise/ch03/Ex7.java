package ch03;

public class Ex7 {

	public static void main(String[] args) {
		int f = 100;
		float c = 5 / 9f * (f - 32);

		System.out.println("Fahrenheit:" + f);
		System.out.println("Celcius:" + String.format("%.2f", c));
	}
}
