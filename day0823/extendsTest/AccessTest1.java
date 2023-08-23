package extendsTest;
import pac.Number;
//class Number {
//	// private
//	private int pnum;
//	private void pmethod() {
//		pnum = 10;
//	}
//	
//	// default
//	int dnum;
//	void dmethod() {
//		System.out.println(pnum);
//	}
//	
//	// public
//	public int punum;
//	public void pumethod() {
//		System.out.println(pnum);
//	}
//}

public class AccessTest1 {

	public static void main(String[] args) {
		Number n1 = new Number();
		//n1.pnum = 100; // 다른 클래스의 private 멤버는 접근 불가
		//n1.pmethod();
		
		//n1.dnum = 100; // 같은 패키지에 있는 클래스 객체의 default 멤버는 접근 가능
		n1.dmethod();
		n1.setDnum(100);
		
		n1.punum = 100; // public 어디서든 접근 가능
		n1.dmethod();
	}
}
