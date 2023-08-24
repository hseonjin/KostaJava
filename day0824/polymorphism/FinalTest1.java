package polymorphism;

// final 변수는 생성자에서 초기화하거나, 변수 선언시 초기화해준다

class TempClass {
	// final 변수 초기화
	// 방법1
	// final int x=20;

	// 방법2
	final int x; // 객체들이 각각 다름 값으로 상수화 시켜서 초기화할 때
	static final int sx = 100; // 생성자에서 초기화할 수 없음, 명시적으로 초기화 (생성자 초기화x)

	TempClass(int x) {
		this.x = x;
	}

	void method(int x) {// this.x=x;}
	}
}

public class FinalTest1 {

	public static void main(String[] args) {
		final int n;
		n=10;
		System.out.println(n);
		
		new TempClass(20);
		new TempClass(30);
	}
}
