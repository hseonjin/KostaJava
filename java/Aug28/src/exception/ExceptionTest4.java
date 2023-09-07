package exception;

public class ExceptionTest4 {

	public static void method1() throws Exception { // throws Exception 처리
		String str = null;
		System.out.println(str.toString());

		try {
			System.out.println(str.toString());
		} catch (NullPointerException e) {
			System.out.println("method1에서 처리");
//			throw e; // 호출한 메소드가 throw 받아 나머지 예외 처리 가능
			throw new Exception("예외 생성");
		}
	}

	public static void main(String[] args) {
		
		try {
			method1();
		} catch (Exception e) { // throws Exception을 처리하지 않은 경우 Exception e 대신 NullPointerException e
			System.out.println("main에서 처리");
		}
		System.out.println("main이 method1의 나머지 예외 처리"); // 메소드를 호출한 클래스에 메소드 예외처리를 위임할 수 있다
	}
}