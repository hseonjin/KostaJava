package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Student8 implements Comparable{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	int total; // 총점
	int schoolRank; // 전교등수

	Student8(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

		total = kor + eng + math;
	}

	int getTotal() {
		return total;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public int compareTo(Object o) {
//		Student클래스의 기본정렬을 이름(name)이 아닌 총점(total)을 기준으로 한 내림차순으로 변경한 다음,
//		총점을 기준으로 각 학생의 전교등수를 계산하고 전교등수를 기준으로 오름차순 정렬하여 출력하시오
		if (o instanceof Student8) {
			Student8 stu = (Student8) o;
			return stu.total - total; // 내림차순 정렬
		} else {
			return -1;
		}

	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage()
				+ "," + schoolRank;
	}
} // class Student8

class Ex08 {
	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.
		int prevRank = -1; // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int length = list.size();
		// 1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.
		for (int i = 0; i < length; i++) {
			Student8 s = (Student8) list.get(i);

			// 1.1 총점(total)이 이전총점(prevTotal)과 같으면 이전 등수(prevRank)를 등수(schoolRank)로 한다.
			if (s.total == prevTotal) {
				s.schoolRank = prevRank;
				// 1.2 총점이서로 다르면, 등수(schoolRank)의 값을 알맞게 계산해서 저장한다.
				// 이전에 동점자 였다면, 그 다음 등수는 동점자의 수를 고려해야한다. (실행결과 참고)

			} else {
				s.schoolRank = i + 1;
			}

			// 1.3 현재 총점과 등수를 이전총점(prevTotal)과 이전등수(prevRank)에 저장한다.
			prevRank = s.schoolRank;
			prevTotal = s.total;
		}

	}

	public static void main(String[] args) {
		ArrayList<Student8> list = new ArrayList<>();
		list.add(new Student8("이자바", 2, 1, 70, 90, 70));
		list.add(new Student8("안자바", 2, 2, 60, 100, 80));
		list.add(new Student8("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student8("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student8("김자바", 1, 2, 80, 80, 90));
		calculateSchoolRank(list);
		Iterator<Student8> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
