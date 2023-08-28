package constructorPac;

class Person2 {
	int age;
	String name;
	Person2() {
		this("none", 0); 
		// 생성자에서 다른 생성자 호출, 반드시 생성자 맨 처음에 호출해야 함
	}
	Person2(String n, int a) {
		age = a;
		name = n;
	}
	Person2(String n) {
		this(n, 0);
		System.out.println(n);
//		name = n;
//		age = 0;
	}
	Person2(int a) {
		this("none", a);
//		age = a;
//		name = "none";
	}
	
	Person2(Person2 p) {
		name = p.name;
		age = p.age;
	}
	
	String info(Person2 this) {
		return "이름:"+name+"나이:"+age; // this 붙여도 되고 안붙여도 자동생성
	}
}

public class ConstructorTest1 {

	public static void main(String[] args) {
		Person2 per1 = new Person2("홍길동", 20);
		per1.info(); // Person.info(per1)
		Person2 per2 = new Person2();
		per2.name = "고길동";
		per2.age = 30;
		per2.info(); // Person.info(per2)
		Person2 per3 = new Person2("차길동");
		Person2 per4 = new Person2(30);
		Person2 par5 = new Person2(per1);
	}
}
