package ch11;

import java.util.*;

//성적평균의 범위별로 학생 수를 세기 위한 것
//TreeSet이 학생들의 평균을 기준으로 정렬하도록 compare(Object o1, Object o2)와 
//평균점수의 범위를 주면 해당 범위에 속한 학생의 수를 반환하는 getGroupCount()를 완성하라.
//[Hint] TreeSet의 subSet(Object from, Object to)를 사용하라.

class Student6 implements Comparable<Student6> {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	Student6(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int getTotal() {
		return kor + eng + math;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
	}

	public int compareTo(Student6 o) {
		if (o instanceof Student6) {
			Student6 tmp = (Student6) o;
			return name.compareTo(tmp.name);
		} else {
			return -1;
		}
	}
} // class Student6

class Ex06 {
	static int getGroupCount(TreeSet<Student6> tset, int from, int to) {
		// SortedSet<Student6> ss =tset.subSet(new Student6("", 0,0,from,from,from), new Student6("", 0, 0, to, to, to));
		// return ss.size();
		return tset.subSet(new Student6("", 0,0,from,from,from), new Student6("", 0, 0, to, to, to)).size(); // 범위에 해당하는 객체 수 리턴

	}

	public static void main(String[] args) {
		TreeSet<Student6> set = new TreeSet<>(new Comparator<Student6> (){
			public int compare(Student6 o1, Student6 o2) {
				// 정석 방법-Average를 통해 비교하려면 사용하기
				// if(o1.getAverage() > o2.getAverage()) return 1;
				// else if(o1.getAverage() < o2.getAverage()) return -1;
				// else return 0;
				
				// 평균을 기준으로 정렬하도록
				return o1.getTotal() - o2.getTotal();
			}
		});
		set.add(new Student6("홍길동", 1, 1, 100, 100, 100));
		set.add(new Student6("남궁성", 1, 2, 90, 70, 80));
		set.add(new Student6("김자바", 1, 3, 80, 80, 90));
		set.add(new Student6("이자바", 1, 4, 70, 90, 70));
		set.add(new Student6("안자바", 1, 5, 60, 100, 80));
		
		Iterator it = set.iterator();
		
		while (it.hasNext())
			System.out.println(it.next());
		
		System.out.println("[60~69] :" + getGroupCount(set, 60, 70));
		System.out.println("[70~79] :" + getGroupCount(set, 70, 80));
		System.out.println("[80~89] :" + getGroupCount(set, 80, 90));
		System.out.println("[90~100] :" + getGroupCount(set, 90, 101));
	}
}
