package polymorphism;

import java.awt.Point;

class MyClass {
	Point p;
	MyClass() {
		p = new Point();
	}
}

class YourClass extends MyClass {
	int x;
}

public class PointTest1 {

	public static void main(String[] args) {
		YourClass c = new YourClass();
		System.out.println(c.p.x);
	}

}
