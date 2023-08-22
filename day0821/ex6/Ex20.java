package ex6;

public class Ex20 {
	
	static int[] shuffle(int[] arr) {
		
		// 복제 (원본을 그대로 두고 shuffle)
		int[] mixarr = new int[arr.length];
		System.arraycopy(arr, 0, mixarr, 0, arr.length);
		// 또는, int[] maxarr = arr.clone();
		
		
		for(int i=0; i<100; i++) {
			int idx1 = (int)(Math.random() * arr.length);
			int idx2 = (int)(Math.random() * arr.length);
			int temp = mixarr[idx1];
			mixarr[idx1] = mixarr[idx2];
			mixarr[idx2] = temp;
		}
		return mixarr;
		
//		for(int i=0; i<100; i++) {
//			int idx1 = (int)(Math.random() * arr.length);
//			int idx2 = (int)(Math.random() * arr.length);
//			int temp = arr[idx1];
//			arr[idx1] = arr[idx2];
//			arr[idx2] = temp;
//		}
//		return arr;
	}
	
	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original); // arr - original 같은 주소를 가지고 있음

		System.out.println(java.util.Arrays.toString(original)); // 원본
		System.out.println(java.util.Arrays.toString(result)); // 복제한 original로 shuffle한 결과
		// original - result 값은 같음
		System.out.println(original==result);
		
//		shuffle(original);
//		System.out.println(java.util.Arrays.toString(original));
		
	}
}