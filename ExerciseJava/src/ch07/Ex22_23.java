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

//(1)클래스명:Circle
//조상클래스:Shape
//멤버변수:double r-반지름

class Circle extends Shape {
	double r;
	
	public Circle(){}
	
	public Circle(double r) {
//		super(p);
		this.r = r;
	}
	
//	Circle(double r) {
//		this(new Point(0, 0), r); // Circle(Point p, double r)를 호출
//	}

	@Override
	double calcArea() {
		return r * r * Math.PI;
	}
}

//(2)클래스명:Rectangle
//조상클래스:Shape
//멤버변수:double width-폭
//double height-높이

//메서드명:isSquare
//기능:정사각형인지 아닌지를 알려준다. (width나 height가 0이 아니고 width와 height가 같으면 true를 반환)
//반환타입:boolean
//매개변수:없음

class Rectangle extends Shape {
	double width; // 폭
	double height; // 높이
	
	public Rectangle(){}
	
	public Rectangle(double width, double height) {
//		super(p);
		this.width = width;
		this.height = height;
	}

//	Rectangle(double width, double height) {
//		this(new Point(0, 0), width, height);
//	}


	@Override
	double calcArea() {
		return width * height;
	}

	boolean isSquare() {
		return width * height != 0 && (width == height);
	}
}

class Ex22_23 {

//	메서드명 : sumArea
//	기능 : 주어진 배열에 담긴 도형들의 넓이를 모두 더해서 반환한다.
//	반환타입 : double
//	매개변수 : Shape[] arr

	public static double sumArea(Shape[] arr) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i].calcArea();
		}
		return sum;
	}

	public static void main(String[] args) {

		Shape[] arr = { new Circle(5.0), new Rectangle(3, 4), new Circle(1)};

		System.out.println("면적의 합: " + sumArea(arr));
	}
}