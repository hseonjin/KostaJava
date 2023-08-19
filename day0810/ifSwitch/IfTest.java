package ifSwitch;

public class IfTest {

	public static void main(String[] args) {
		int i = -10;
		if (i > 0) {
			System.out.println("A+");
		} else if (i == 0) {
			System.out.println("A0");
		} else {
			System.out.println("A-");
		}

		int j = 50;
		String grade = "";
		if (j >= 90) {
			grade = "A";
		} else if (j >= 80) {
			grade = "B";
		} else if (j >= 70) {
			grade = "C";
		} else if (j >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}

		if (!grade.equals("F") && j % 10 >= 7) {
			grade += "+";
		} else if (!grade.equals("F") && j % 10 >= 4) {
			grade += "0";
		} else if (!grade.equals("F")) {
			grade += "-";
		} else {
			grade = "F";
		}
		System.out.println(grade);
	}

}
