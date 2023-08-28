package exception;

public class ExceptionTest1 {

	public static void main(String[] args) {
		// String은 null인 경우 예외 발생
		String str = null;
		// System.out.println(str.toString());

		// 예외 처리
		try {
			System.out.println(str.toString()); // 이 실행에서 Exception이 발생하는 경우
		} catch (NullPointerException e) { // Exception을 처리하기 위한 문장을 실행
			e.printStackTrace(); // stack을 추적하여 exception 발생 출력
//			System.out.println("null 입니다");
			System.out.println(e.getMessage()); /// 어떤 에러인지 찾아서 출력 "null"
		}
		System.out.println("종료");
		
		
		// 맞는 예외처리를 해주지 않는 경우 예외처리를 해주지 않은 것과 같다
		int[] arr = new int[5];
		try {
			System.out.println(str.toString());
			for(int i=0; i<=arr.length; i++) {
				arr[i] = i*10;
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("종료");
	}

}
