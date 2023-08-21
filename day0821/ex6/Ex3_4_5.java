package ex6;

class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	int getTotal() {
		return kor + eng + math;
	}

	float getAverage() {
		float avg = (float) getTotal() / 3;
		return Math.round(avg * 10) / 10.0f;
	}

	String info() { 
		return name + "," + ban + "," + no + "," + kor + "," + eng +
				"," + math + "," + getTotal() + "," + getAverage();
	}
}

public class Ex3_4_5 {

	public static void main(String[] args) {
		Student stu = new Student();
		stu.name = "홍길동";
		stu.ban = 1;
		stu.no = 1;
		stu.kor = 100;
		stu.eng = 60;
		stu.math = 76;

		System.out.println("이름: " + stu.name);
		System.out.println("총점: " + stu.getTotal());
		System.out.println("평균: " + stu.getAverage());

		System.out.println(stu.info());
	}

}
