package ch05;

public class Ex12 {

	public static void main(String[] args) {
		// 추가문제
		// 3m 짜리 우물 바닥에 달팽이가 있다.
		// 달팽이는 낮동안 55cm를 올라갈 수 있고, 날이 지고 잠을 자는 동안 3cm 미끄러져 내려온다.
		// 달팽이가 우물 밖으로 나오는 데 며칠이 걸리는가
		// 반복문과 조건문을 이용하여 프로그램 작성

		int well = 300;
		int days = 0;
		int up = 0;

		while (true) {
			up += 55; // 낮동안 55cm 올라감
			days += 1; // 올라가고 해가 지면 하루가 더해짐
			if (up >= well) { // 올라간 높이가 우물 높이 이상이 되면
				break; // 멈추기
			} else { // 우물 높이 이상이 되지 않으면
				up -= 3; // 3cm 미끄러져 내려옴
			}
		}
		System.out.println(days);
	}
}

//int depth = 3*100; // 우물의 깊이
//int height = 0; // 올라간 높이
//final int up = 55; // 올라갈 수 있는 높이
//final int down = 3; // 미끄러지는 높이
//int day = 0; // 걸린 날짜수

//while(true) {
//	height += up;
//	days++;
//	if(depth<=height) break;
//	height -= down;
//}
