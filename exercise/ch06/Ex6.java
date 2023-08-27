package ch06;

public class Ex6 {
	// 두 점 (x, y)와 (x1, y1) 간의 거리를 구함
	static double getDistance(int x, int y, int x1, int y1) {
		return Math.sqrt((x1-x)*(x1-x) + (y1-y)*(y1-y));
	}
	public static void main(String[] args) {
		System.out.println(getDistance(1,1,2,2));
	}

}

//두 점 사이의 거리 공식
//루트((x2-x1)**2 + (y2-y1)**2)