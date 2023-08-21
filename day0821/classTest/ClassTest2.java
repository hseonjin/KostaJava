package classTest;

// Person 클래스
class Person {
	String name;
	int age;
	
	String info() { // method 정의
		return "이름: " + name + ", 나이: " + age;
	}
}

public class ClassTest2 {

	public static void main(String[] args) {
		Person per1 = new Person(); // 객체 생성?
		per1.name = "허선진";
		per1.age = 24;
		
		System.out.println(per1.info()); // method 호출
		
		// 객체 배열
		// 5명의 person을 만들어보고자 함 -> 참조변수 5개를 생성한 것
		// 객체를 다루기 위한 참조변수가 만들어진 것일 뿐, 객체가 저장되지 않았으므로
		// 객체 배열의 각 요소에 객체를 생성하여 저장해주어야 함
		Person[] parr = new Person[5];
		parr[0] = new Person();
		parr[1] = new Person();
		parr[2] = new Person();
		parr[3] = new Person();
		parr[4] = new Person();
		

	}

}