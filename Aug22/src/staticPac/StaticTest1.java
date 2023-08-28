package staticPac;

class Number {
	int inum; // 인스턴스 변수
	static int snum; // 클래스 변수
	
	void imethod() {
		inum = 10;
		snum++; // instance 메서드에서는 static 변수 사용 가능
		imethod2();
		smethod(); // instance 메서드에서는 static 메소드 호출 가능
	} // 인스턴스 메서드
	
	void imethod2() {}
	
	static void smethod() {
		snum = 10;
		// inum = 10; // static method에서는 instance 변수 사용 불가
		smethod2();
		// imethod(); // static method에서는 instance 메서드 호출 불가
	} // 클래스 메서드
	
	static void smethod2() {}
}

public class StaticTest1 {

	public static void main(String[] args) {
		// instance 변수는 객체 생성해야만 사용 가능
		// new를 통해 인스턴스가 생성될 때 메모리 저장
		Number n = new Number();
		System.out.println(n.inum); 
		n.imethod(); // Number.imethod() 불가
		n.smethod(); // static 메서드는 참조변수를 통해서도 접근 가능하지만 권장하지는 않음
		
		// static(class) 변수는 객체 생성 없이 접근 가능
		// 프로그램 시작시 이미 변수가 생성되어 있기 때문
		System.out.println(Number.snum); 
		System.out.println(n.snum); // static 변수는 참조변수를 통해서도 접근 가능하지만 권장하지는 않음
		Number.smethod();
		
	}
}
