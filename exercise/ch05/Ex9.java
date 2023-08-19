package ch05;

public class Ex9 {

	public static void main(String[] args) {
		char[][] star = {
				{'*','*',' ',' ',' '},
				{'*','*',' ',' ',' '},
				{'*','*','*','*','*'},
				{'*','*','*','*','*'}
		};
		// ȸ���� �迭�� ���
		char[][] result = new char[star[0].length][star.length]; 
		
		// ���� �迭 ���
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		// ȸ���� �迭 ���
		/* 	star[0][0] -> result[0][3]
			star[0][1] -> result[1][3]
			...
			star[1][0] -> result[0][2]
			star[1][1] -> result[0][2]
			=> star[i][j] -> result[j][star.length-i-1]
		*/
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				result[j][star.length-i-1] = star[i][j];
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}
