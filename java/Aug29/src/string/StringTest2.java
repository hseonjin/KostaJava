package string;

import java.util.Scanner;

public class StringTest2 {

	public static void main(String[] args) {

		// 해당 리터럴이 몇 번째 인덱스에 위치하는지 반환 (찾지 못했으면 -1)
		String str = "Good Luck";
		int idx = str.indexOf("L");
		System.out.println(idx);

		// 모든 문자가 같아야 하며, 첫 글자의 인덱스 반환
		int idx2 = str.indexOf("Luck");
		System.out.println(idx2);

		String str2 = "apple place";
		int idx3 = str2.indexOf("p"); // 1
		int idx4 = str2.lastIndexOf("p"); // 6, 해당 리터럴이 마지막으로 나타나는 인덱스를 반환
		System.out.println(idx3);
		System.out.println(idx4);

		// p를 t로 변경하기
		String str3 = str2.replace('p', 't');
		System.out.println(str3);

		String str4 = str2.replace("place", "banana");
		System.out.println(str4);

		// 구분자를 기준으로 문자열을 잘라주는 역할
		String fruitStr = "apple, banana, pineapple, melon, strawberry";
		String[] fruitArr = fruitStr.split(", ");
		for(int i=0; i<fruitArr.length; i++) {
			System.out.println(fruitArr[i]);
		}

		// 문자열 자르기
		System.out.println(fruitStr.substring(7, 13));

		System.out.println("Y/N을 선택하세요: ");
		Scanner sc = new Scanner(System.in);
		String answer = sc.nextLine();
		if(answer.toLowerCase().equals("y") ) {
			System.out.println("Yes 선택");
		} else if(answer.toUpperCase().equals("N")) {
			System.out.println("No 선택");
		}

		// 좌우 공백(\t 포함) 제거 (문자 중간에 있는 공백은 의미있는 공백이므로 제거하지 않음
		String str5 = "     Hello     ".trim();
		System.out.println(str5);
//		Point p = new Point(10, 10);
		String str6 = String.valueOf(100);
		String str7 = "" + 100;
		System.out.println(str6);
		System.out.println(str7);
	}
}
