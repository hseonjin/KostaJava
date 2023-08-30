package set;

import java.util.HashSet;

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
		 return name.compareTo(o.name); // 이름순
//		return age - o.age; // 나이순
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person == false) return false;
		Person p = (Person) obj;
		return name.equals(p.name) && age == p.age;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
}

public class HashSetTest { // 순서가 없고, 중복을 허용하지 않는다 

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(234);
		hs.add(45);
		hs.add(23);
		hs.add(8);
		hs.add(8);
		hs.add(1);
		
		for(Integer h : hs) {
			System.out.println(h);
		}
		
		HashSet<Person> ahs = new HashSet<>();
		ahs.add(new Person("홍길동", 23));
		ahs.add(new Person("홍길동", 30));
		ahs.add(new Person("고길동", 33));
		ahs.add(new Person("하길동", 40));
		ahs.add(new Person("고길동", 33));
		
		for(Person p : ahs) {
			System.out.println(p);
		}
	}

}
