package classTest;

class Account {
	String id;
	String name;
	int balance;
	int deposit;

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

// #2 계좌 개설하기
class Bank {
	Account[] accList = new Account[100];
	int accCnt; // 실제 개설된 계좌의 개수

	// 호출만 하기 떄문에 리턴타입 X
	void makeAccount(String id, String name, int money) {
		Account acc = new Account();
		acc.id = id;
		acc.name = name;
		acc.balance = money;
		accList[accCnt++] = acc;
	}

	void allAccountInfo() {
		for (int i = 0; i < accCnt; i++) {
			System.out.println(accList[i].info());
		}
	}

	void accountInfo(String id) {
		for (int i = 0; i < accCnt; i++) {
			if (accList[i].id == id) {
				System.out.println(accList[i].info());
			}
		}
	}

	void deposit(String id, int inMoney) {
		for (int i = 0; i < accCnt; i++) {
			if (accList[i].id == id) {
				accList[i].balance += inMoney;
			}
		}
	}

	void withdraw(String id, int outMoney) {
		Account acc = new Account();
		for (int i = 0; i < accCnt; i++) {
			if (accList[i].id == id) {
				accList[i].balance -= outMoney;
			}
		}
	}
}

public class ClassTest5 {
	public static void main(String[] args) {

		// #2 계좌 개설
		Bank bank = new Bank();
		bank.makeAccount("10001", "고길동", 100000);
		bank.makeAccount("10002", "김길동", 200000);

		// 개설된 모든 계좌의 정보 출력
		System.out.println("---개설된 모든 계좌의 정보 출력---");
		bank.allAccountInfo();
		// 계좌번호: 10001, 이름: 고길동, 잔액: 100000 출력
		// 계좌번호: 10002, 이름: 김길동, 잔액: 200000 출력

		// 계좌번호가 파라미터와 같은 경우만 출력
		System.out.println("---일치하는 계좌번호를 찾아 계좌 정보 출력---");
		bank.accountInfo("10001");
		// 계좌번호: 10001, 이름: 고길동, 잔액: 100000 출력

		// 계좌번호를 찾아 입금
		System.out.println("---일치하는 계좌번호를 찾아 입금---");
		bank.deposit("10001", 10000);
		bank.accountInfo("10001");
		// 계좌번호: 10001, 이름: 고길동, 잔액: 110000 출력

//		// 계좌번호를 찾아 출금
		System.out.println("---일치하는 계좌를 찾아 출금---");
		bank.withdraw("10001", 5000);
		bank.accountInfo("10001");
//		// 계좌번호: 10001, 이름: 고길동, 잔액: 105000 출력

		// #1
//		Account acc1 = new Account();
//		acc1.id = "10001";
//		acc1.name = "고길동";
//		acc1.balance = 100000;
//		System.out.println(acc1.info());
//		acc1.deposit(10000);
//		System.out.println(acc1.info());
//		acc1.withdraw(20000);
//		System.out.println(acc1.info());
	}
}

// 계좌번호: 10001, 이름: 고길동, 잔액: 100000 출력
// 계좌번호: 10001, 이름: 고길동, 잔액: 110000 출력
// 계좌번호: 10001, 이름: 고길동, 잔액: 90000 출력