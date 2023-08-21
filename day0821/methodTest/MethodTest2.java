package methodTest;

class Data {
	int x;
}

public class MethodTest2 {
	
	// 1
	static void increment(int x) {
		x += 1;
		System.out.println(x); // 11
	}
		
	// 2
	static void increment2(Data d) { // 주소를 통해 원본을 가짐
		d.x += 1;
		System.out.println(d.x); // 11
	}
	
	public static void main(String[] args) {
		Data data = new Data();
		data.x = 10;
		
		// 1
		increment(data.x); // 같은 클래스 안에 있으므로 호출 가능
		System.out.println(data.x); // 10 increment의 x와 data의 x는 다른 저장공간을 가짐
		
		// 2
		increment2(data);
		System.out.println(data.x); // 11 
		
	}
}