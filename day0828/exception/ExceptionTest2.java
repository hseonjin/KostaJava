package exception;

public class ExceptionTest2 {

	public static void main(String[] args) {
		int[] arr1 = { 10, 20, 30, 40, 50 };
		int[] arr2 = { 2, 4, 6, 0 };
		int tot = 0; // sum(arr1[i]/arr2[i])
		int count = arr1.length;
		double avg = 0; // tot/개수

//		for(int i=0; i<arr1.length; i++) {
//			System.out.println(arr1[i]/arr2[i]);
//		}

//		Exception in thread "main" java.lang.ArithmeticException: / by zero
//		at exception.ExceptionTest2.main(ExceptionTest2.java:9)

		// 1. 예외처리
		try { // 아래 for문에 Exception 발생할 경우
			for(int i=0; i<arr1.length; i++) {
				System.out.println(arr1[i]/arr2[i]);
			}
		} catch (ArithmeticException e) { // 이렇게 처리해준다
			System.out.println(e.getMessage());
			System.out.println("예외");
		}
		System.out.println("종료");

		// 2. 예외 처리 후 다음에 계속해서 진행하고 싶은 경우
		for (int i = 0; i < arr1.length; i++) {
			try { 
				System.out.println(arr1[i] / arr2[i]);
			} catch (ArithmeticException e) { 
				System.out.println(e.getMessage());
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("종료");

		
		// 3. 결과를 출력하고 싶을 때 catch문 비워두기
		for (int i = 0; i < arr1.length; i++) {
			try { 
				tot += arr1[i] / arr2[i];
			} catch (ArithmeticException e) { // 나머지가 0이거나 결과가 이상한 경우에는 아무 처리 하지 않고 넘어간다
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
		System.out.println(tot); 
		System.out.println("종료");
		
		for (int i = 0; i < arr1.length; i++) {
			try { 
				tot += arr1[i] / arr2[i];
			} catch (Exception e) { // ArithmeticException (Exception 상속)
				count--;
			}
//			} catch (ArrayIndexOutOfBoundsException e) {
//				count--;
//			}
		}
		System.out.println(tot); 
		System.out.println(tot/(double)count);
		System.out.println("종료");
	}
}