package extendsPac;

class Person {
	int age;
	String name;
	
	// 생성자
	Person() {} 
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	String info() {
		return "이름: " + name + ", 나이: " + age;
	}
}

class Student extends Person {
	String major;
	int grade;
	
	Student() {} // person의 기본 + student의 기본
	
	Student(String name, int age, String major, int grade) {
		super(name, age);
		this.major = major;
		this.grade = grade;
	}
	
	@Override
	String info() {
		return super.info() + ", 전공: " + major + ", 학년: " + grade;
	}
}

public class InheritTest1 {

	public static void main(String[] args) {
		// 자식 객체를 통해 부모 클래스의 속성과 메소드를 사용할 수 있다
		Student stu = new Student(); //"홍길동", 20\
		// 부모에서 상속받은 속성 사용
		stu.name = "홍길동";
		stu.age = 20;
		// 자식 객체에서 정의한 속성 사용
		stu.major = "컴공";
		stu.grade = 1;
		System.out.println(stu.info());
		
		// 부모 객체는 자식 객체의 속성과 메소드를 사용할 수 없다
		Person per = new Person();
		per.name = "안녕히";
		per.age = 30;
		// per.major = "컴공";
		System.out.println(per.info());
		
		
		// 생성자를 만들어 호출
		Student stu2 = new Student("돈많은", 40, "금융", 3);
	}
}
