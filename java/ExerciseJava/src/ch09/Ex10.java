package ch09;

import javax.management.StringValueExp;

//메서드명 : format
//기 능 : 주어진 문자열을 지정된 크기의 문자열로 변환한다. 나머지 공간은 공백으로 채운다.
//반환타입 : String
//매개변수 : String str - 변환할 문자열
//int length - 변환된 문자열의 길이
//int alignment - 변환된 문자열의 정렬조건
//(0:왼쪽 정렬, 1: 가운데 정렬, 2:오른쪽 정렬)

public class Ex10 {

	static String format(String str, int length, int alignment) {
		// 1. length의 값이 str의 길이보다 작으면 length만큼만 잘라서 반환한다.
		if (length < str.length())
			return str.substring(0, length);
		
		// 2. 1의경우가 아니면, length크기의 char배열을 생성하고 공백으로 채운다.
		char[] source = str.toCharArray(); // arraycopy에서 소스가될 배열
		char[] newArr = new char[length];
		for(int i=0; i<length; i++) {
			newArr[i] = ' ';
		}

		// 3. 정렬조건(alignment)의 값에 따라 문자열(str)을복사할 위치를 결정한다. (System.arraycopy()사용)
		switch(alignment) {
		case 0: System.arraycopy(source, 0, newArr, 0, source.length); break; // stroooo
		case 1: System.arraycopy(source, 0, newArr, (length-str.length()) / 2, source.length); break; // oostroo
		case 2: System.arraycopy(source, 0, newArr, length-str.length(), source.length); break; // oooostr
		}
		
	// 4. 2에서 생성한 char배열을 문자열로 만들어서 반환한다.
		return String.valueOf(newArr);
		// return new String(ch);
	}

	public static void main(String[] args) {
		String str = "가나다";
		System.out.println(format(str, 7, 0)); // 왼쪽 정렬 (stroooo)
		System.out.println(format(str, 7, 1)); // 가운데 정렬 (oostroo)
		System.out.println(format(str, 7, 2)); // 오른쪽 정렬 (oooostr)
	}
}