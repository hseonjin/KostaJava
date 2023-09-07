package ch07;

public class Ex20 {

	public static void main(String[] args) {
		Parent2 p = new Child2();
		Child2 c = new Child2();
		System.out.println("p.x = " + p.x);
		p.method();
		System.out.println("c.x = " + c.x);
		c.method();
	}
}

class Parent2 {
	int x = 100;

	void method() {
		System.out.println("Parent2 Method");
	}
}

class Child2 extends Parent2 {
	int x = 200;

	void method() {
		System.out.println("Child2 Method");
	}
}

//p.x = 100
//Child2 Method
//c.x = 200
//Child2 Method
