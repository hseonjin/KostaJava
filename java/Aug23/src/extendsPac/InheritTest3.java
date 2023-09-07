package extendsPac;

class Parent {
//	Parent() {} // 기본생성자가 있어야 자식 객체에 에러가 발생하지 않음
	Parent(int n) {
		System.out.println("Parent()");
	}
}

class Child extends Parent {
	int m;
	Child() {
		super(0);
		System.out.println("Child()");
	}
	Child(int n, int m) {
		super(n);
		this.m = m;
	}
}

public class InheritTest3 {

	public static void main(String[] args) {
//		 Parent p = new Parent();
		Child c = new Child();
	}
}
