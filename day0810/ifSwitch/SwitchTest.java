package ifSwitch;

import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		// 국어, 영어, 수학 점수를 입력받아 총점과 평균 계산, 점수별 등급 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수: ");
		int kor = sc.nextInt();
		System.out.println("영어점수: ");
		int eng = sc.nextInt();
		System.out.println("수학점수: ");
		int math = sc.nextInt();

		int total = kor + eng + math;
		double avg = total / (double) 3;

		String grade = "";
		switch ((int) avg / 10) {
		case 10:
			grade = "A";
			break;
		case 9:
			grade = "B";
			break;
		case 8:
			grade = "C";
			break;
		case 7:
			grade = "D";
			break;
		default:
			grade = "F";
		}
		System.out.println(grade);
	}

}
