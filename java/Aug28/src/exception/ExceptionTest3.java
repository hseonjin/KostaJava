package exception;

public class ExceptionTest3 {

	// 메소드 안에서 예외가 발생하여 처리하지 않으면
	// 호출하는 메소드(Main)에게 위임하는 것 (throws Exception)
	public static void main(String[] args) throws Exception {
		
		
		try { // 예외를 생성해서 발생시켜줌
			throw new Exception("예외 발생"); 
		} catch(Exception e) { // Exception은 최상위
			System.out.println(e.getMessage());
		}
	}

}
