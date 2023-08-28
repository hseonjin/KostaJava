package exception;

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 클래스의 문자열을 String으로 출력
	@Override
	public String toString() {
		return "이름: " + name + ", 나이: " + age;
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person == false) return false;
		Person p = (Person) obj;
		return name.equals(p.name) && age == p.age;
	}
}

public class ToStringTest {

	public static void main(String[] args) {
		Person p1 = new Person("hong", 30);
		Person p2 = new Person("hong", 30);
//		String str = "!!!" + p;
//		System.out.println(p);
//		System.out.println(str);
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
	}

}
