package classTest;

public class ClassTest1 {

	public static void main(String[] args) {
		// Student 클래스의 객체를 참조하기 위해 참조변수 선언
		// new~ : 클래스의 객체를 생성 후 객체의 주소를 참조변수에 저장
		Student stu1 = new Student();
		Student stu2;
		
		// Student 클래스의 객체를 사용
		stu1.name = "홍길동";
		stu1.address = "서울시 금천구";
		stu1.grade = 4;
		stu1.num = 10001;
		
		// 매번 작성해야 하는 경우 불편 -> Student 클래스에 기능을 삽입
//		System.out.println(String.format("이름: %s, 주소: %s, 학년: %d, 학번: %d", 
//				stu1.name, stu1.address, stu1.grade, stu1.num));
		System.out.println(stu1.info());
		
	}
}
