package bankAndEx;

import java.util.Scanner;

public class Bank {
	Account[] accs = new Account[100];
	int accCnt;
	Scanner sc = new Scanner(System.in);

	int menu() { // sel이 int타입이기 때문에 반환타입도 int
		int sel;
		System.out.println("[코스타 은행]");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌조회");
		System.out.println("5. 전체계좌조회");
		System.out.println("0. 종료");
		System.out.println("선택 >> ");
		return Integer.parseInt(sc.nextLine());
	}

	// 공통부분
	Account searchAccById(String id) {
		for (int i = 0; i < accCnt; i++) {
			if (accs[i].id.equals(id)) {
				return accs[i];
			}
		}
		return null;
	}

	// 계좌개설
	void makeAccount() {
		System.out.println("[계좌 개설]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("입금액: ");
		int money = Integer.parseInt(sc.nextLine());
		accs[accCnt++] = new Account(id, name, money);
	}

	// 입금
	void deposit() {
		System.out.println("[입금]");
		System.out.println("계좌번호: ");
		String id = sc.nextLine();
		Account acc = searchAccById(id);
		if (acc == null) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		System.out.println("입금액: ");
		int money = Integer.parseInt(sc.nextLine());
		acc.deposit(money);
	}

	// 출금
	void withdraw() {
		System.out.println("[출금]");
		System.out.println("계좌번호: ");
		String id = sc.nextLine();
		Account acc = searchAccById(id);
		if (acc == null) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		System.out.println("출금액: ");
		int money = Integer.parseInt(sc.nextLine());
		acc.withdraw(money);
	}

	// 계좌조회
	void accountInfo() {
		System.out.println("[계좌조회]");
		System.out.println("계좌번호: ");
		String id = sc.nextLine();
		Account acc = searchAccById(id);
		if (acc == null) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		System.out.println(acc.info());
	}

	// 전체 계좌조회
	void allAccountInfo() {
		for (int i = 0; i < accCnt; i++) {
			System.out.println(accs[i].info());
		}
	}
	
	public static void main(String[] args) {
		// bank 클래스 내에 메서드 작성하기
		Bank bank = new Bank();
		int sel;
		
		while(true) {
			sel = bank.menu();
			
			if(sel == 0) break;
			
			switch(sel) {
			case 1: bank.makeAccount(); break;
			case 2: bank.deposit(); break;
			case 3: bank.withdraw(); break;
			case 4: bank.accountInfo(); break;
			case 5: bank.allAccountInfo(); break;
			}
		}
		
	}

}