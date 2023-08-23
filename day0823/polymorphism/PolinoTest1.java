package polymorphism;

// 부모클래스
class Shape {
	String color;
	void draw() {
		System.out.println("shape");
	}
}

// 자식클래스
class Circle extends Shape{
	int x;
	int y;
	int r;
	
	@Override
	void draw() {
		System.out.println("circle");
	}
}

public class PolinoTest1 {

	public static void main(String[] args) {
		
		 Circle cc = new Circle();
		 cc.color = "green";
		 cc.r = 20;
		 cc.x = cc.y = 10;
		 cc.draw(); // Circle의 method 호출됨
		 
		// upcasting 자식 객체를 부모 객체에 넣는 것
		// 타입(부모) 객체가 가진 정보만 사용할 수 있다
		// 자식 객체를 생성하지만 타입은 부모일 때,
		// 자식객체에서 overriding을 했다면 자식메서드를 호출한다
		Shape c = new Circle();
		c.color = "red";
		c.draw();
		
	}

}
