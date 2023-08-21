package ex6;

class MyPoint {
	int x;
	int y;
	
	// 1
//	MyPoint (int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
	
//	double getDistance(int x1, int y1) {
//		return Math.sqrt((x1-x)*(x1-x) + (y1-y)*(y1-y));
//	};
	
	// 2
	double getDistance(MyPoint pos) {
		return Math.sqrt((x-pos.x)*(x-pos.x) + (y-pos.y)*(y-pos.y));
	};
	
}

public class Ex7 {
	public static void main(String[] args) {
		// 1
//		MyPoint p = new MyPoint(1,1);
//				
//		//p(1,1) (2,2) 거리 구하기
//		System.out.println(p.getDistance(2,2));
		
		// 2
		MyPoint pos1 = new MyPoint();
		pos1.x = 1;
		pos1.y = 1;
		
		MyPoint pos2 = new MyPoint();
		pos2.x = 2;
		pos2.y = 2;
		
		System.out.println(pos1.getDistance(pos2));
	}
}

//두 점 사이의 거리 공식
//루트((x2-x1)**2 + (y2-y1)**2)