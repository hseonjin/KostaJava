package extendsTest;

class A {
//	A() {} // 1. B에 에러 발생 방지를 위해 기본생성자 작성
	A(int m) {}
}

class B extends A{
	// 기본생성자 존재하는 상태에서 에러가 발생
	// 2. 에러발생 방지를 위해 참조
	B(int m){
		super(m);
	}
	
}

public class InheritTest4 {

	public static void main(String[] args) {

	}
}
