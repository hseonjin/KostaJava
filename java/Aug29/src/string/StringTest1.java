package string;

public class StringTest1 {

	public static void main(String[] args) {

		String a = "a";
		a += "b";

		int n = 10;
		n = 20;

		String s1 = null;
		String s2 = "";
		char c = 'a';

		// 문자 합치기
		String s3 = new String("abc");
		char[] carr = { 'a', 'b', 'c' };
		String s4 = new String(carr);
		System.out.println(s3);
		System.out.println(s4);
		StringBuffer sb = new StringBuffer("abc");
		String s5 = new String(sb);
		System.out.println(s5);

		// 문자 합치기
		String bs = "hello ";
		String cs = bs.concat("world");
		System.out.println(bs);
		System.out.println(cs);
		System.out.println(bs); // 원래의 문자가 바뀌는 것이 아님

		// 리터럴을 포함하는지 t/f
		System.out.println(cs.contains("hello"));

		// 파일 이름이 "hwp"로 끝나는지 t/f
		String filename = "test.txt";
		System.out.println(filename.endsWith("hwp"));

		// 배열에 들어있는 파일 이름 중 'txt'로 끝나는 원소만 가져오기
		String[] files = { "test.txt", "temp.hwp", "backup.txt" };
		for (int i = 0; i < files.length; i++) {
			if (files[i].endsWith("txt")) {
				System.out.println(files[i]);
			}
		}

	}

}
