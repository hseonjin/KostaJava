package extendsPac;

class Base {
	int bnum;
	void method1() {} //1
	void method2() {} //2
	
	
}

class Derived extends Base{
	int dnum;
	void method1(int n) {} //5
	void method2() { // 6
		method1(); // 가능
		//method2(); // 잘못 사용할 확률 높음
		super.method2(); // 가능
	} 
	void method2(int n) { //3, 오버로딩
		method2(); // 가능, 6
	} 
	void method3() {} //4
}

public class InheritTest2 {

	public static void main(String[] args) {
		Base b = new Base();
		b.bnum=10;
		b.method1(); //1
		b.method2(); //2
		
		Derived d = new Derived();
		d.bnum = 20;
		d.dnum = 30;
		d.method1(); //1
		d.method2(); //오버로딩한 경우 파라미터를 통해 호출되는 메서드 구분 가능
		d.method3(); //4
	}
}
