package operator;

public class OperTest2 {

	public static void main(String[] args) {
		// 부호 연산자
		int i = -10;
		System.out.println("i = " + i);
		System.out.println("+i = " + +i);
		System.out.println("-i = " + -i);

		// 부정 연산자
		boolean power = false;
		System.out.println("power = " + power);
		System.out.println("!poswer = " + !power);
		System.out.println("!poswer = " + !power);

		// 보수 연산자
		i = 10;
		System.out.println("i = " + i);
		System.out.println("i 보수값 = " + ~i);
	}

}
