package polymorphism;

class Base {
	int x=1;
	void method() {
		System.out.println("Base method");
	}
}

class Derived extends Base {
	int x=2;
	int y=3;
	void method() { // overriding
		System.out.println("Derived method");
	}
}

public class PolinoTest3 {

	public static void main(String[] args) {
		Base base1 = new Derived(); // upcasting
		base1.method(); // 자식 메소드가 출력된다 (다형성) new로 생성된 객체의 메소드가 출력되는 것
		base1.x = 10;
		// base1.y = 20;
		
		Base base2 = new Base();
		base2.method();
		
		// 원래 base1은 Derived를 new 한 것이니 메모리에 저장된 것은 Derived, 타입만 바꾸어준 것
		Derived derived = (Derived)base1; // downcasting 
		derived.y = 20;
		
		Derived derived2 = (Derived)base2; 
		derived2.y = 30;
		
		
		if (base1 instanceof Derived) { // true
			Derived derived1 = (Derived)base1;
			derived1.y = 20;
		}
		
		if (base2 instanceof Derived) { // false
//			Derived derived2 = (Derived)base2; 
			derived2.y = 30;
		}
		
		Base base3 = new Derived();
		base3.method(); // Derived method 호출
		System.out.println(base3.x); // Base의 x값 출력
	}

}