package overloadPac;

class Person {
	int age;
	String name;
	
	// 오버로딩
	Person() { // 기본생성자, return타입 사용하지 않음 (껍데기를 만들어주는 것)
	}
	Person(String n, int a) { // 생성자를 하나라도 만들면 기본생성자가 자동으로 만들어지지 않음
		age = a;
		name = n;
	}
	Person(String n) {
		name = n;
	}
	Person(int a) {
		age = a;
	}
}

public class OverloadTest1 {

	public static void main(String[] args) {
		Person per1 = new Person("홍길동", 20);
		Person per2 = new Person();
		per2.name = "고길동";
		per2.age = 30;
		Person per3 = new Person("차길동");
		Person per4 = new Person(30);
		
	}
}
