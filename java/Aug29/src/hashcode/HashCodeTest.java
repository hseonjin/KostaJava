package hashcode;

import java.util.HashSet;

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}

	@Override
	public String toString() {
		return name + "," + age;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person == false) return false;
		Person p = (Person)obj;
		return super.equals(p.name) && age == p.age;
	}
}

public class HashCodeTest {

	public static void main(String[] args) {
		String str1 = "hong";
		String str2 = "hong";
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());

		Person p1 = new Person("hong", 23);
		Person p2 = new Person("hong", 23);
		System.out.println(p1.equals(p2));
		System.out.println(p2.hashCode());
		System.out.println(p2.hashCode());

		HashSet hs = new HashSet();
		// set은 동일한 데이터가 들어가지 않는다.
		// 내부에서 같은 데이터인지 여부를 입력되는 데이터의 hashCode()와 equals()함수로 판단한다
		hs.add(10);
		hs.add(20);
		for (Object o : hs) {
			System.out.println(o); // 레퍼런스와 클래스의 조합
		}

		System.out.println(p1.equals(p2));
	}
}
