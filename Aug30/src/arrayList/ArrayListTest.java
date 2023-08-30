package arrayList;

import java.util.ArrayList;

class Person implements Comparable<Person>{
	String name;
	int age;
	
	Person(){}
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "(" + name + "," + age + ")";
	}
	
	@Override
	public int compareTo(Person o) {
		// return name.compareTo(o.name); // 이름순
		return age - o.age; // 나이순
	}
}


public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(100);
		int n = (Integer)al.get(0); // 박싱 해주어야 한다
		
		Integer in = 200;
		int in2 = in; // 언박싱
		
		ArrayList al2 = new ArrayList();
		al2.add(new Person());
		Person p = (Person) al2.get(0);
		
		ArrayList<Person> p3 = new ArrayList<>();
		 // 제너릭 타입 사용(클래스화)-오브젝트 타입이 미정인 경우 
		// 컴파일 시점에 클래스파일이 만들어짐
	}

}
