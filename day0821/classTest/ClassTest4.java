package classTest;

class TClass1 {
	void method1() {
		int num1;
		method2(); // 같은 클래스의 메소드끼리 서로 호출 가능 (참조변수 없이도 가능 = 객체 없이도 가능)
	}

	void method2() {
		int num2;
		method3();
	}

	void method3() {
		int num3;
	}
}

public class ClassTest4 {

	public static void main(String[] args) {
		TClass1 tc = new TClass1();
		tc.method1(); // method1이 method2를 호출함

	}
}

/* memory Area TClass1, ClassTest4
 * Stack Area tc, num1, num2, num3 순으로 쌓임
 * Heap Area tc 
 */