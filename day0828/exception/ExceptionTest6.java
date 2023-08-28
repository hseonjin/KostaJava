package exception;

import java.io.IOException;

public class ExceptionTest6 {

	static void method1() throws IOException, Exception{
		boolean flag = true;
		if (flag) {
			throw new IOException("입출력 예외");
		} else {
			throw new Exception("모든 예외");
		}
	}
	
	public static void main(String[] args) {
		try {
			method1();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// 또는
		
//		try {
//			method1();
//		} catch (Exception e) { // Exception이 최상위이기 때문에 IOException도 가능 -> 대신 일괄처리가 된다.
//			System.out.println(e.getMessage());
//		}
	}
}