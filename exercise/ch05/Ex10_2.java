package ch05;

public class Ex10_2 {

	public static void main(String[] args) {
		// ���� => ��ȣȭ Ǯ��
		char[] abcCode = 
				{ '`', '~', '!', '@', '#', '$', '%', '^', '&', '*',
				'(', ')', '-', '_', '+', '=', '|', '[', ']', '{',
				'}', ';', ':', ',', '.', '/' };

		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };

		String result = "`~!wer"; // ���ڿ�
		String src = "";

		// ���ڿ� src�� ���ڸ� charAt()���� �ϳ��� �о ��ȯ �� result�� ����
		for (int i = 0; i < result.length(); i++) {
			char ch = result.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				for (int j = 0; j < numCode.length; j++) {
					if (ch == numCode[j]) {
						src += j;
						break;
					}
				}
			} else {
				for (int j = 0; j < abcCode.length; j++) {
					if (ch == abcCode[j]) {
						src += (char) (j + 'a');
						break;
					}
				}
			}
		}
		System.out.println("result:" + result);
		System.out.println("src:" + src); // abc123
	}
}


/*
 * for(int i=0; i<result.length(); i++){
 * 	char ch = result.charAt(i);
 * 	int idx = -1; // for������ ã�� ���� ���� ��� [0]���� ��µǴ� ������ �����ϱ� ���� -1�� �ʱ�ȭ
 * 	if(ch>='a' && ch<='z') { a~z�� ���� numcode���� ã�� �ƴҶ� abcCode���� ã��
 *		for(int j=0; j<numCode.length; j++) {
 *			if(ch == numCode[j] {
 *				idx = j;
 *				break;
 *			}
 *		}
 *		if(idx!=-1) src += (char)('0'+idx)
 *		// src += '0'+idx; 
 *	} else {
 * 		for(int j=0; j<abcCode.length; j++) {
 * 			if(ch==abcCode[j]0 {
 * 			idx = j;
 * 			break;
 * 			}
 * 		}
 * 		
 * 		src += 'a' + idx
 * 	}
 */