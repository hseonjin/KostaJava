package shape;

public class Triangle extends Shape{
	Point p1 = new Point();
	Point p2 = new Point();
	Point p3 = new Point();
	
	// getter,setter
	
	
	// 생성자
	public Triangle() {}
	//1
	public Triangle(String color, int x1, int y1, int x2, int y2, int x3, int y3) {
		super(color);
		this.p1.x = x1;
		this.p1.y = y1;
		this.p2.x = x2;
		this.p2.y = y2;
		this.p3.x = x3;
		this.p3.y = y3;
	}
	//2
	public Triangle(String color, Point p1, Point p2, Point p3) {
		super(color);
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	@Override
	public String info() {
		return String.format("[삼각형: 색(%s), 점1(%d, %d), 점2(%d, %d), 점3(%d, %d)]", 
				color, p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
	}
	
}
