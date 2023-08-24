package ch07;

abstract class Shape {
	Point p;

	Shape() {
		this(new Point(0, 0));
	}

	Shape(Point p) {
		this.p = p;
	}

	abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드

	Point getPosition() {
		return p;
	}

	void setPosition(Point p) {
		this.p = p;
	}
}

class Point {
	int x;
	int y;

	Point() {
		this(0, 0);
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}
}

class Circle extends Shape {
	double r;
	
	public Circle (Point p) {
		super(p);
	}
	
	@Override
	double calcArea() { // 도형 면적 계산
		return 0;
	}

}

class Rectangle extends Shape {
	int width;
	int height;

	@Override
	double calcArea() {
		return 0;
	}

}

class Exercise7_23 {
	
	double sumArea(Shape[] arr) {
		
		return 0;
	}
	/*
	 * (1) sumArea메서드를 작성하시오.
	 */
	public static void main(String[] args) {
//		Shape[] arr = { new Circle(5.0), new Rectangle(3, 4), new Circle(1) };
//		System.out.println("면적의 합:" + sumArea(arr));
	}
}