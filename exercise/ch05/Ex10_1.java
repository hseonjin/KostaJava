package ch05;

public class Ex10_1 {

	public static void main(String[] args) {
		char[] abcCode = 
				{ '`', '~', '!', '@', '#', '$', '%', '^', '&', '*',
				'(', ')', '-', '_', '+', '=', '|', '[', ']', '{',
				'}', ';', ':', ',', '.', '/' };
		
		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
		
		String src = "abc123";
		String result = "";
		
		// ���ڿ� src�� ���ڸ� charAt()���� �ϳ��� �о ��ȯ �� result�� ����
		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);
			// ch�� ������ �� abcCode
			if (ch >= 'a') {
				result += abcCode[ch - 'a'];
			} else { // ch�� ������ �� numCode
				result += numCode[ch - '0'];
			}
		}
		System.out.println("src:" + src);
		System.out.println("result:" + result);
	}
}
