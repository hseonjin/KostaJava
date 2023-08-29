package ch04;

public class Ex3 {

	public static void main(String[] args) {
		// 1
		int sum1 = 0;
		int total = 0;
		for(int i=1; i<=10; i++) {
			sum1 += i;
			total += sum1;
		}
		System.out.println(total);
		
		// 2
		int sum2 = 0;
		for(int i=0; i<=10; i++) {
			for(int j=0; j<=i; j++) {
				sum2 += j;
			}
		}
		System.out.println(sum2);
	}

}
