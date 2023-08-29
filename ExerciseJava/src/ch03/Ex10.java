package ch03;

public class Ex10 {

	public static void main(String[] args) {
		char ch = 'A';
		char lowerCase = (ch >= 'A' && ch <= 'Z') ? (char)(ch + 32) : ch;
		
		System.out.println("upperCase: " + ch);
		System.out.println("lowerCase: " + lowerCase);
	}

}
