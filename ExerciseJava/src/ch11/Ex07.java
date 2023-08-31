package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;



class Student7 {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	Student7(String name, int ban, int no, int kor, int eng, int math) {
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
} // class Student7

class BanNoAscending implements Comparator<Student7> {
	//ArrayList에 담긴 Student7인스턴스들이 반(ban)과 번호(no)로 오름차순 정렬되게 하시오.
	//(반이 같은 경우 번호를 비교해서 정렬한다.)
	public int compare(Student7 o1, Student7 o2) {
		if(o1 instanceof Student7 && o2 instanceof Student7) {
			Student7 s1 = (Student7) o1;
			Student7 s2 = (Student7) o2;
			if (s1.ban - s2.ban == 0) {
				return s1.no - s2.no;
			}
			return s1.ban - s2.ban;
		}
		return -1;
	}
}

class Ex07 {
	public static void main(String[] args) {
		ArrayList<Student7> list = new ArrayList<>();
		list.add(new Student7("이자바", 2, 1, 70, 90, 70));
		list.add(new Student7("안자바", 2, 2, 60, 100, 80));
		list.add(new Student7("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student7("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student7("김자바", 1, 2, 80, 80, 90));
		Collections.sort(list, new BanNoAscending());
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
