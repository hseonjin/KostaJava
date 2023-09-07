package com.test06.biz;

import com.test06.entity.Coffee;
import com.test06.entity.Coke;
import com.test06.entity.Drink;
import com.test06.entity.Juice;

public class VendingMachineBiz {
	private int balance = 1000; // 현재 잔액
	private Drink[] cartList = new Drink[3]; // 구입목록 배열
	private int count = 0; // 배열갯수

	public void cartDrink(Drink drink) {
		// 음료수 구매 로직을 구현하는 메서드이다
		// 배열에 저장된 개수와 배열의 크기가 같으면, 기존의 배열보다 사이즈가 3배인 배열을 생성한 후,
		// 기존의 배열 내용을 새로운 배열에 복사하고 새로운 배열과 기존 배열을 바꾼다.
		// 배열에 구매한 개수만큼 저장하고 count값을 증가시킨다.
		if (count == cartList.length) {
			Drink[] newList = new Drink[count * 3];
			System.arraycopy(cartList, 0, newList, 0, count);
			cartList = newList;
		}
		cartList[count] = drink;
		count++;

		// 매개변수로 넘겨받은 Drink 타입에 대한 메시지를 출력한다. (실행결과 참조)
		// 메시지 출력시 Drink 타입의 toString() 메소드를 사용한다. xxxx
		// 잔액과 구매가격을 비교하여 부족한 경우에 에러 메시지를 출력한다.
		// 현재 갖고 있는 잔액에서 구매가격만큼 뺀다.
		// 현재 잔액을 출력한다. ( Sample Run 참조 )
		if (drink instanceof Juice) {
			if (balance - 200 < 0) {
				System.out.println("잔액이 부족하여 주스 구매가 불가능합니다.");
				return;
			}
			System.out.println("쥬스를 구입했습니다.");
			drink.setPrice(drink.getPrice() + 200);
			balance -= 200;
		} else if (drink instanceof Coffee) {
			if (balance - 100 < 0) {
				System.out.println("잔액이 부족하여 커피 구매가 불가능합니다.");
				return;
			}
			System.out.println("커피를 구입했습니다.");
			drink.setPrice(drink.getPrice() + 100);
			balance -= 100;
		} else if (drink instanceof Coke) {
			if (balance - 50 < 0) {
				System.out.println("잔액이 부족하여 코크 구매가 불가능합니다.");
				return;
			}
			System.out.println("코크를 구입했습니다.");
			drink.setPrice(drink.getPrice() + 50);
			balance -= 50;
		}

		System.out.println("현재 잔액: " + balance + "원");

	}

	public void printCart() {

		// 구매 목록 배열에 저장된 정보를 출력하는 메서드이다.
		// 1) 배열에 저장된 데이터 타입에 따른 개수를 count한다.
		int coffeeCnt = 0, cokeCnt = 0, juiceCnt = 0;
		for (Drink drink : cartList) {
			if (drink instanceof Coffee) {
				coffeeCnt++;
			} else if (drink instanceof Coke) {
				cokeCnt++;
			} else if (drink instanceof Juice) {
				juiceCnt++;
			}
		}

		// 2) 배열에 저장된 총 구매금액을 계산한다.

		// 3) 구매목록과 남은 잔액을 출력한다.( 실행결과 참조 )
		System.out.println("=====음료수 구입 목록=====");
		System.out.println("쥬스 : " + juiceCnt);
		System.out.println("커피 : " + coffeeCnt);
		System.out.println("코크 : " + cokeCnt);
		System.out.println("==========================");
		System.out.println("사용 금액: " + (1000-balance));
		System.out.println("남은 금액: " + balance);
	};

	public void printDrinkList() {
//		음료수명 가격
//		=============== 
//		커피 100원
//		코크 50원
//		주스 200원
//		--------------- 
//		현재 잔액: 1000 원 

//		음료수 자판기내의 모든 음료수를 출력하는 메서드이다
//		 1) drinkList 배열에 저장된 내용을 출력한다. ( 실행결과 참조 ) 
//			음료수명은 한글로 출력한다. ( 예: 커피, 코크, 주스 )
		String[][] drinkList = { { "커피", "\t\t", "100원" }, { "코크", "\t\t", "50원" }, { "주스", "\t\t", "200원" } };
		System.out.println("음료수명\t가격");
		System.out.println("=====================");
		for (int i = 0; i < drinkList.length; i++) {
			for (int j = 0; j < drinkList[i].length; j++) {
				System.out.print(drinkList[i][j]);
			}
			System.out.println();
		}
		System.out.println("=====================");
//		2) 마지막에는 잔액을 출력한다. ( 실행결과 참조 )
		System.out.println("현재 잔액 : " + balance);
	};
}
