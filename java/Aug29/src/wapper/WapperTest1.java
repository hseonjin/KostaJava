package wapper;

public class WapperTest1 {

	public static void main(String[] args) {
		int m = 10;
		Integer n = m; // Boxing 알아서 int가 Integer로 변환됨
		int r = n; // Unboxing
		long l = m;
		
		Object obj = 100; // Boxing + Upcasting
	}

}
