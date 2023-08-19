package ch05;

public class Ex4_2 {

	public static void main(String[] args) {
		// 변형 => 배열이 가변배열일 때,
		int[][] arr = {
				{ 5, 5, 5, 5, 5 }, 
				{ 10, 10, 10, 10}, 
				{ 20, 20, 20}, 
				{ 30, 30, 30, 30, 30, 30} };
		int total = 0;
		float average = 0;
		int count = 0; // 배열 원소의 총 개수 저장할 변수
		
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				total += arr[i][j];
			}
			count += arr[i].length;
		}
		average = (float)total / count;

		System.out.println("totat=" + total);
		System.out.println("average=" + average);
	}
}
