package shapeProejct;

public class Rectangle extends Shape{
	Point startPos = new Point();
	int width;
	int height;

	
	// getter,setter
	
	// 생성자
	public Rectangle() {}
	//1
	public Rectangle(String color, int x, int y, int width, int height) {
		super(color);
		this.startPos.x = x;
		this.startPos.y = y;
		this.width = width;
		this.height = height;
	}
	//2
	public Rectangle(String color, Point startPos, int width, int height) {
		super(color);
		this.startPos = startPos;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String info() {
		return String.format("[사각형: 색(%s), 시작점:(%d, %d), 너비(%d), 높이(%d)]",
				color, startPos.x, startPos.y, width, height);
				
	}
	
	
}
