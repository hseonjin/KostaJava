package ch06;

public class Ex19 {

	public static void change(String str) {
		str += "456";
	}

	public static void main(String[] args) {
		// 상수영역을 저장하고 그 주소를 n에 넣는다
		// 상수영역에 ABC123이 있는지 확인하고 있으면 그 주소를,
		// 없으면 새로 만들어주는 것
		String str = "ABC123";
		String str1 = "ABC123";
		System.out.println(str == str1);
		

		String str2 = new String("ABC123");
		String str3 = new String("ABC123");
		System.out.println(str2 == str3);

//		System.out.println(str);
//		change(str);
//		System.out.println("After change:" + str);
	}
}