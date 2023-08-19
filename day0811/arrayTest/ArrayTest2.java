package arrayTest;

public class ArrayTest2 {

	public static void main(String[] args) {
		// 배열의 경우 선언만 해주면 0으로 기본값이 들어있음.
		int[] arr1 = new int[] { 1, 2, 3, 4, 5 }; // 초기화1
		int[] arr2 = { 1, 2, 3, 4, 5 }; // 초기화2
		int[] arr3;
		arr3 = new int[] { 1, 2, 3, 4, 5 };
		// arr3 = {1,2,3,4,5}; // 선언과 초기화를 따로 할 때 new를 생략 불가
	}

}
