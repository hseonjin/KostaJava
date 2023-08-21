package variableTest;

class MyNumber {
	int num; // 클래스 내 변수는 클래스 내 메소드들이 공유.
	
	void func1(int n) {
		int number = n;
		num = number;
	}
	
	void func2(int n) {
		int number = n;
		num = number;
	}
	
	// func1, func2의 number은 각각 다른 아이들
}

class MyMath2 {
	int x, y;
	int add() {
		return x + y;
	}
	int multi() {
		return x * y;
	}
}


public class VariableTest2 {

	public static void main(String[] args) {
		MyNumber mn = new MyNumber();
		System.out.println(mn.num); // 0
		mn.func1(10);
		System.out.println(mn.num); // 10
		mn.func2(20);
		System.out.println(mn.num); // 20
		
		MyMath2 mm = new MyMath2();
		mm.x = 10;
		mm.y = 20;
		System.out.println(mm.add());
		System.out.println(mm.multi());
	}
}