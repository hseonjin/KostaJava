package arrayTest;

public class ArrayTest1 {

	public static void main(String[] args) {
		// 주로 첫번째처럼 사용
		int[] arr; // arr는 배열이 시작하는 주소값(4byte)을 나타냄
		int arr1[];
		
		int[] narr1 = new int[5]; // 하나당 4바이트 차지
		double[] daar1 = new double[5]; // 하나당 8바이트 차지

//			narr1[0] = 1;
//			narr1[1] = 2;
//			narr1[2] = 3;
//			narr1[3] = 4;
//			narr1[4] = 5;

		int sum = 0;
		for (int i = 0; i < narr1.length; i++) {
			sum += narr1[i];
		}
		System.out.println(sum);
	}

}
