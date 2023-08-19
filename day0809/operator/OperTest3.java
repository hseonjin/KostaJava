package operator;

public class OperTest3 {

	public static void main(String[] args) {
		// 정수형, 실수형의 경우 int나 double형보다 작은 것끼리 연산할 경우
		System.out.println(10 / 4);
		System.out.println(10.0 / 4);
		System.out.println((float) 10 / 4);

		int kor = 99, eng = 88, math = 100;
		int total = kor + eng + math;
		double avg = total / 3.0;
		System.out.println("전체점수: " + total + ", 평균: " + avg);

		int mod = 10 % 4;
		System.out.println(mod);

		// byte + byte -> int + int
		byte a = 10;
		byte b = 20;
		byte c = (byte) (a + b);
		System.out.println(c);

		int i1 = 100000;
		int i2 = 200000;
		long i3 = i1 * i2;
		System.out.println(i3);
		// i1*i2 결과값이 int로 오버플로우가 발생(하나라도 long 이어야 함)
		long res = i1 * (long) i2;
		System.out.println(res);

		long l1 = 100000 * 100000L; // 오버플로우로 인해 에러 발생, long으로 변환 후 계산
		System.out.println(l1);

		int i4 = 100000 * 100000 / 100000;
		System.out.println(i4);

		int i5 = 100000 / 100000 * 100000;
		System.out.println(i5);
	}

}
