package operator;

public class OperTest1 {

	public static void main(String[] args) {
		int i = 10;
		System.out.println("i = " + i);
		
		System.out.println("i++의 결과 = " + i++); // 결과값을 출력하고나서 1 증가
		
		i = 10;
		System.out.println("++i의 결과 = " + ++i); // 결과값을 증가시키고 나서 결과값을 출력
		
		System.out.println("i--의 결과 = " + i--);
		
		i = 10;
		System.out.println("--i의 결과 = " + --i);
	}

}
