package methodTest;

class MyMath {
	// 1
//	int add(int x, int y) { // method 정의 (입력의 타입을 명시)
//		int result = x + y;
//		return result;
//		
	// 2. static으로 사용하면 메인클래스에서 객체를 생성할 필요가 없음
	static int add(int x, int y) { // method 정의 (입력의 타입을 명시)
		int result = x + y;
		return result;
	}
		
	static int multi(int x, int y) {
		int result = x * y;
		return result;
	}
}


public class MethodTest1 {

	public static void main(String[] args) {
		// 1
//		MyMath mm = new MyMath(); // static으로 선언하는 경우 필요가 없음
//		int res = mm.add(10, 20); // method 호출
//		System.out.println(res);
		
		// 2. static으로 선언한 경우
		int result = MyMath.add(10, 20);
		System.out.println(result);
		result = MyMath.multi(10,  20);
		System.out.println(result);
		
	}
}