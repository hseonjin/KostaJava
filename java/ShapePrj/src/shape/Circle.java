package shape;

public class Circle extends Shape{
	Point center = new Point();
	int radius;

	// 생성자
	public Circle() {}
	// 1
	public Circle(String color, int x, int y, int radius) {
		super(color);
		this.center.x = x;
		this.center.y = y;
		this.radius = radius;
	}
	// 2
	public Circle(String color, Point center, int radius) {
		super(color);
		this.center = center;
		this.radius = radius;
	}

	
	@Override
	public String info() {
		return String.format("[원: 색(%s), 중심점:(%d, %d), 반지름(%d)]",
				color, center.x, center.y, radius);
	}

	
}
