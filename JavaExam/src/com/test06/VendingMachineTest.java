package com.test06;

import java.util.Scanner;

import com.test06.biz.VendingMachineBiz;
import com.test06.entity.Coffee;
import com.test06.entity.Coke;
import com.test06.entity.Juice;

public class VendingMachineTest {
	static void printMenu(){
		Scanner sc = new Scanner(System.in);
		VendingMachineBiz vm = new VendingMachineBiz();
		
		while (true) {
//			try {
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
			System.out.println("============================");
			System.out.println("[음료수 자판기 관리 시스템] ");
			System.out.println("============================");
			System.out.println("1.전체 음료수 및 잔액 보기");
			System.out.println("2.쥬스 구입하기 ( 200원 )");
			System.out.println("3.커피 구입하기 ( 100원 )");
			System.out.println("4.코크 구입하기 ( 50원 )");
			System.out.println("5.구입한 음료수 목록 보기");
			System.out.println("9.종료");
			System.out.println("============================");
			System.out.println("메뉴 입력 => ");
			int menuNum = sc.nextInt();
			if (menuNum == 9) {
				System.out.println("시스템을 종료합니다.");
				break;
			}

			switch (menuNum) {
			case 1: vm.printDrinkList();
				break;
			case 2: vm.cartDrink(new Juice()); 
				break;
			case 3: vm.cartDrink(new Coffee());
				break;
			case 4: vm.cartDrink(new Coke());
				break;
			case 5: vm.printCart();
				break;
			default: System.out.println("메뉴값을 확인 후 다시 입력하세요.");
			}
		}

	}
	public static void main(String[] args) {
		VendingMachineTest.printMenu();
	}

}