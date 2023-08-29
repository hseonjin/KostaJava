package ch09;

//메서드명 : delChar
//기 능 : 주어진 문자열에서 금지된 문자들을 제거하여 반환한다.
//반환타입 : String
//매개변수 : String src - 변환할 문자열 / String delCh - 제거할 문자들로 구성된 문자열
//[힌트] StringBuffer와 String클래스의 charAt(int i)과 indexOf(int ch)를 사용하라.

public class Ex09 {

	static String delChar(String src, String delCh) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < src.length(); i++) { // 변환할 문자열의 길이만큼
			char ch = src.charAt(i); // 하나하나씩 비교하기 위해 저장
			if (delCh.indexOf(ch) == -1) { // 제거할 문자열에 ch가 있는지 찾아서 없다면(==-1)
				sb.append(ch); // 해당 ch를 StringBuffer에 저장

			}
		}
		return sb.toString(); // 방법1
//		return new String(sb); // 방법2

	}

	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
		System.out.println("(1 2 3 4\t5)" + " -> " + delChar("(1 2 3 4\t5)", " \t"));
	}
}