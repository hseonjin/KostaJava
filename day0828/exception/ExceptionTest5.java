package exception;

public class ExceptionTest5 {

	public static void main(String[] args) {
		String nstr = "123o";
		int n = Integer.parseInt(nstr);
		
//		Exception in thread "main" java.lang.NumberFormatException: For input string: "123o"
//			at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
//			at java.base/java.lang.Integer.parseInt(Integer.java:652)
//			at java.base/java.lang.Integer.parseInt(Integer.java:770)
//			at exception.ExceptionTest5.main(ExceptionTest5.java:7)
	}
}