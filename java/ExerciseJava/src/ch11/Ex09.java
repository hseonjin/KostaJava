package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

//  Student9클래스에 반등수(classRank)를 저장하기 위한 인스턴스변수를 추가하였다. 
// 반등수를 계산하고 반과 반등수로 오름차순 정렬하여 결과를 출력하시오. 

class Student9 implements Comparable<Student9> {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total;
	int schoolRank; // 전교등수
	int classRank; // 반등수

	Student9(String name, int ban, int no, int kor, int eng, int math) {
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

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage()
				+ "," + schoolRank + "," + classRank // 새로추가
		;
	}

	@Override
	public int compareTo(Student9 o) {
		return o.total - total;
	}
} // class Student9

class ClassTotalComparator implements Comparator<Student9> {
	@Override
	public int compare(Student9 o1, Student9 o2) {
		int result = o1.ban - o2.ban; // 반 오름차순
		if (result == 0) 
			result = o2.total - o2.total; // 총점 내림차순
		return result;
	}
}

class Ex09 {
	public static void calculateClassRank(List<Student9> list) {
		// 반 별 총점
		Collections.sort(list, new ClassTotalComparator());
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		for (int i = 0, n = 0; i < length; i++, n++) {
			// 1. 반복문을 이용해서 list에 저장된 Student9객체를 하나씩 읽는다.
			Student9 s = (Student9) list.get(i);
			
			// 1.1 반이 달라지면,(ban와 prevBan가 다르면) 이전 등수(prevRank)와 이전 총점(prevTotal)을 초기화 한다. 
			if (s.ban != prevBan) {
				prevRank = -1;
				prevTotal = -1;
				n = 0;
			}
			// 1.2 총점(total)이 이전총점(prevTotal)과 같으면 이전 등수(prevRank)를 등수(schoolRank)로 한다.
			if (s.total == prevTotal) {
				s.classRank = prevRank;
			} else {
				// 1.3 총점이 서로 다르면, 등수(schoolRank)의 값을 알맞게 계산해서 저장한다.
				// 이전에 동점자였다면, 그 다음 등수는 동점자의 수를 고려해야한다.
				s.classRank = n + 1;
			}
			// 1.4 현재 반과 총점과 등수를 이전 반(prevBan), 이전 총점(prevTotal), 이전 등수(prevRank)에 저장한다.
			prevBan = s.ban;
			prevRank = s.classRank;
			prevTotal = s.total;
		}
	} // public static void calculateClassRank(List list) {

	public static void calculateSchoolRank(List<Student9> list) {
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.
		int prevRank = -1; // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int length = list.size();
		for (int i = 0; i < length; i++) {
			Student9 s = (Student9) list.get(i);
			if (s.total == prevTotal) {
				s.schoolRank = prevRank;
			} else {
				s.schoolRank = i + 1;
			}
			prevRank = s.schoolRank;
			prevTotal = s.total;
		} // for
	}

	public static void main(String[] args) {
		ArrayList<Student9> list = new ArrayList<>();
		list.add(new Student9("이자바", 2, 1, 70, 90, 70));
		list.add(new Student9("안자바", 2, 2, 60, 100, 80));
		list.add(new Student9("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student9("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student9("김자바", 1, 2, 80, 80, 90));
		calculateSchoolRank(list);
		calculateClassRank(list);
		Iterator<Student9> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}