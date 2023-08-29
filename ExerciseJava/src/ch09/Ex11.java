package ch09;

/*
커맨드라인으로 2~9사이의 두 개의 숫자를 받아서 두 숫자사이의 구구단을 출력
하는 프로그램을 작성하시오. 예를 들어 3과 5를 입력하면 3단부터 5단까지 출력한다
*/

class Ex11 {
	public static void main(String[] args) {
		
		if(args.length < 2) 
			System.out.println("시작 단과 끝 단, 두 개의 정수를 입력해주세요.\n"
					+ "USAGE : GugudanTest 3 5");
		int start = Integer.parseInt(args[0]);
		int end = Integer.parseInt(args[1]);
		
		if (start<2 || end>9) 
			System.out.println("단의 범위는 2와 9사이의 값이어야 합니다.\n"
					+ "USAGE : GugudanTest 3 5");
		
		if (start>end) {
			int t = start;
			start = end;
			end = t;
		}
		
		for(int i=start; i<=end; i++) {
			for(int j=1; j<=9; j++) {
				System.out.println(String.format("%d * %d = %d", i, j, i*j));
			}
			System.out.println();
		}
	}
}
