package set;

import java.util.*;

public class TreeSetTest1 {

	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(100);
		ts.add(50);
		ts.add(30);
		ts.add(150);
		
		System.out.println(ts);
		
		TreeSet<Person> tsp = new TreeSet<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age; // 내림차순으로 하려면 뺼셈을 반대로 해주면 됨 (o2.age - o1.age)
			}
		});
		tsp.add(new Person("hong", 20));
		tsp.add(new Person("song", 10));
		tsp.add(new Person("gong", 50));
		tsp.add(new Person("tong", 30));
		tsp.add(new Person("hong", 20));
		tsp.add(new Person("pong", 40));
		System.out.println(tsp);
		SortedSet<Person> subList = tsp.subSet(new Person("", 20), new Person("", 60)); // 범위
		System.out.println(subList);
	}
}