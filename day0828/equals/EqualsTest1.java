package equals;

// 복소수
class Complex {
	int real; // 실수부
	int imaginary; // 허수부

	public Complex(int real, int imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Complex == false) return false;
		Complex c = (Complex) obj;
		return real == c.real && imaginary == c.imaginary;
	}
	
	@Override
	public String toString() {
		return real + "+" + imaginary + "i";
	}
}

public class EqualsTest1 {

	public static void main(String[] args) {
		Complex c1 = new Complex(3, 5);
		Complex c2 = new Complex(3, 5);
		Complex c3 = new Complex(5, 3);
		System.out.println(c1.equals(c2)); // true
		System.out.println(c1.equals(c3)); // false
		System.out.println(c1); // 3 + 5i
		System.out.println(c3); // 5+3i
	}

}
