package bank.main;

import java.util.Scanner;

import bank.Bank;
import bank.SpecialAccount;
import bank.account.*;
import bank.exc.BankError;
import bank.exc.BankException;

class Account {
	String id;
	String name;
	int balance;

	// 생성자 만들기
	Account(String aid, String aname, int money) {
		id = aid;
		name = aname;
		balance = money;
	}

	String info() {
		return String.format("계좌번호: %s, 이름: %s, 잔액: %d", id, name, balance);
	}

	void deposit(int i) {
		balance += i;
	}

	void withdraw(int i) {
		if (balance >= i) {
			balance -= i;
		}
	}
}

public class Bank3 {
	Account[] accs = new Account[100];
	int accCnt;
	Scanner sc = new Scanner(System.in);

	int menu() throws BankException { // throws Exception을 통해 main() 메소드에서 예외 처리를 해줄 것
		System.out.println("[코스타 은행]");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌조회");
		System.out.println("5. 전체계좌조회");
		System.out.println("0. 종료");
		System.out.println("선택 >> ");
		
		int sel = Integer.parseInt(sc.nextLine());
		if(!(sel>=0 && sel<=5)) {
			try {
				throw new BankException("메뉴오류", BankError.MENU);
			} catch(BankException e) {
				System.out.println(e);
				menu();
			}
		}

		return sel;

	}

	// 추가되는 부분 - Special Account
	void selAccMenu() {
		System.out.println("[계좌개설]");
		System.out.println("1. 일반계좌");
		System.out.println("2. 특수계좌");
		System.out.print("선택>>");
		int sel = Integer.parseInt(sc.nextLine());
		if (sel == 1)
			makeAccount();
		else
			makeSpecialAccount();
	}

	// 계좌개설
	void makeAccount() {
		System.out.println("[일반계좌 개설]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();
		Account acc = searchAccById(id);
		if (acc != null) {
			System.out.println("계좌번호가 중복됩니다.");
			return;
		}
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("입금액: ");
		int money = Integer.parseInt(sc.nextLine());
		accs[accCnt++] = new Account(id, name, money);
	}

	// 특수계좌개설
	void makeSpecialAccount() {
		System.out.println("[특수계좌 개설]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();
		Account acc = searchAccById(id);
		if (acc != null) {
			System.out.println("계좌번호가 중복됩니다.");
			return;
		}
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("입금액: ");
		int money = Integer.parseInt(sc.nextLine());
		System.out.print("등급(V, G, S, N): ");
		String grade = sc.nextLine();
//		accs[accCnt++] = new SpecialAccount3(id, name, money, grade);
	}

	// 공통부분 (id찾기)
	Account searchAccById(String id) {
		for (int i = 0; i < accCnt; i++) {
			if (accs[i].id.equals(id)) {
				return accs[i];
			}
		}
		return null;
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
		// overriding 해두었기 때문에 downcasting 하지 않아도 됨
		// 만약 특수계좌만 취급하는 경우에는 downcasting이 필요함
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
		Bank3 bank = new Bank3();
		int sel;

		while (true) {
			try {
				sel = bank.menu();
				if (sel == 0)
					break;
				switch (sel) {
				case 1:
					bank.selAccMenu();
					break;
				case 2:
					bank.deposit();
					break;
				case 3:
					bank.withdraw();
					break;
				case 4:
					bank.accountInfo();
					break;
				case 5:
					bank.allAccountInfo();
					break;
				}
			} catch (Exception e) {
				System.out.println("입력 형식이 맞지 않습니다. 다시 선택하세요.");
			}

		}
	}
}
