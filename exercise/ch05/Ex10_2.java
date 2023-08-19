package ch05;

public class Ex10_2 {

	public static void main(String[] args) {
		// 변형 => 암호화 풀기
		char[] abcCode = 
				{ '`', '~', '!', '@', '#', '$', '%', '^', '&', '*',
				'(', ')', '-', '_', '+', '=', '|', '[', ']', '{',
				'}', ';', ':', ',', '.', '/' };

		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };

		String result = "`~!wer"; // 문자열
		String src = "";

		// 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 result에 저장
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
 * 	int idx = -1; // for문에서 찾는 값이 없는 경우 [0]으로 출력되는 오류를 방지하기 위해 -1로 초기화
 * 	if(ch>='a' && ch<='z') { a~z일 때는 numcode에서 찾고 아닐땐 abcCode에서 찾기
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