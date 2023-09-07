package ch09;

/*
 메서드명 : printGraph
 기 능 : 주어진 배열에 담긴 값만큼 주어진 문자를 가로로 출력한 후, 값을 출력한다.
 반환타입 : 없음
 매개변수 : int[] dataArr - 출력할 그래프의 데이터 / char ch - 그래프로 출력할 문자.
 */

public class Ex04 {

	static void printGraph(int[] dataArr, char ch) {
		/*
		 * (1) printGraph메서드를 작성하시오.
		 */
		System.out.println("1번 방법");
		for (int i=0; i<dataArr.length; i++) {
			for(int j=0; j<dataArr[i]; j++) {
				System.out.print(ch);
			}
			System.out.println(dataArr[i]);
		}
		
		// 향상된 for문
		System.out.println();
		System.out.println("2번 방법-향상된 for문");
		for(int n : dataArr) {
			for(int i=0; i<n; i++) {
				System.out.print(ch);
			}
			System.out.println(n);
		}
		
	}

	public static void main(String[] args) {
		printGraph(new int[] { 3, 7, 1, 4 }, '*');
	}
}