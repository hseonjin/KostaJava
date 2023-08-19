package ch03;

public class Ex9 {
	public static void main(String[] args) {
		char ch = 'z';
		boolean b = (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= 0 && ch <= 9) ? true : false;
		System.out.println(b);
	}
}
