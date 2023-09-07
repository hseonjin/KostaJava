package stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		StringTokenizer st3 = new StringTokenizer("apple#banana#orange", "#", true); // true인 경우 구분자도 하나의 문자로 인식하고 출력 (기본 false)
		while(st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
		
		StringTokenizer st2 = new StringTokenizer("apple#banana@orange,  kiwi", "#@,"); // split()과 달리, 여러개의 구분자를 넣을 수 있고, 띄어쓰기도 인식
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		
		StringTokenizer st1 = new StringTokenizer("apple banana orange", " ");
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
		
	}
}