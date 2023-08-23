package polymorphism;

class AA {
	int a;
	void methodA() {} //1
	void method() {} //2
	void info() {
		System.out.println(getPay());
	}
	int getPay() {
		return 0;
	}
}

class BB extends AA {
	int b;
	void methodB(){} //3
	void method(){} //4
	
	@Override
	int getPay() {
		return 100;
	}
}

public class PolinoTest2 {

	public static void main(String[] args) {
		AA obj = new BB();
		obj.methodA(); // 1
		
		// 부모타입에 없는 메소드 사용할 수 없음
		// obj.methodB(); 
		// obj.b = 20;
		// -------------
		
		obj.method(); //4 메소드명이 동일하다면 자식 메소드 호출
		obj.a = 10;
		obj.info(); // 100
	}
}

/*
자식 객체를 부모 변수에 넣을 경우, 부모에는 없는 자식의 변수나 함수는 사용할 수 없다
단, 오버라이딩 한 경우 부모 변수로 자식의 함수를 호출한다 
*/
