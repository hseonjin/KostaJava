package classTest;

public class Student { // Student 클래스
	// 객체의 속성(멤버변수)
	String name;
	int grade;
	int num;
	String address;
	
	// 객체의 기능(메서드)
	String info() {
		return String.format("이름: %s, 주소: %s, 학년: %d, 학번: %d", 
				name, address, grade, num);
	}
}
