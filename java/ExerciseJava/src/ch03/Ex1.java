package ch03;

public class Ex1 {

	public static void main(String[] args) {
		int x = 2;
		int y = 5;
		char c = 'A'; // 'A'�� �����ڵ�� 65

		System.out.println(1 + x << 33); // 6
		System.out.println(y >= 5 || x < 0 && x > 2); // true
		System.out.println(y += 10 - x++); // 13, x=3
		System.out.println(x += 2); // 5
		System.out.println(!('A' <= c && c <= 'Z')); // false
		System.out.println('C' - c); // 67-65 = 2
		System.out.println('5' - '0'); // 5
		System.out.println(c + 1); // 66
		System.out.println(++c); // 67
		System.out.println(c++); // 67, c=68
		System.out.println(c); // 68
	}

}
