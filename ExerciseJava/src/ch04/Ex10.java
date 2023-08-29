package ch04;

public class Ex10 {

	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		
		while(true) {
			if (num == 0) break;
			sum += num % 10; // 나머지를 모두 더한다 5		4	  3	  2  1
			num /= 10; // 몫을 계산하여 더한 수는 제외 1234	123	  12  1  break
		}
		System.out.println("sum: " + sum);
	}

}
