package ifSwitch;

import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		// ����, ����, ���� ������ �Է¹޾� ������ ��� ���, ������ ��� ���
		Scanner sc = new Scanner(System.in);
		System.out.println("��������: ");
		int kor = sc.nextInt();
		System.out.println("��������: ");
		int eng = sc.nextInt();
		System.out.println("��������: ");
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
