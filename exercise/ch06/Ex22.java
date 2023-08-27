package ch06;

public class Ex22 {

	static boolean isNumber(String str) {
		// 1
		// 문자열이 null이거나 빈문자열이라면 false 반환
		if(str == null || str.length()==0) return false;
		for(int i=0; i<str.length(); i++) {
			if(!(str.charAt(i) >= '0' && str.charAt(i) <= '9'))
				return false;
		}
		return true;
	}

		// 2
//		if(str == null || str.length()==0) return false;
//		boolean flag = true;
//		for (int i = 0; i < str.length(); i++) {
//			char ch = str.charAt(i);
//
//			if (!(ch >= '0' && ch <= '9')) {
//				flag = false;
//				break;
//			}
//		}
//		return flag;
//	}

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
	}
}
