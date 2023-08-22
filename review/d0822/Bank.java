package d0822;

// 0821 ClassTest5 복습
// 계좌개설, 개설된 모든 계좌의 정보 출력, 계좌번호를 찾아 입금/출금

class Account {
	String id;
	String name;
	int balance;

	// 생성자 만들기
	Account(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	String info() {
		return String.format("계좌번호: %s, 이름: %s, 잔액: %d", id, name, balance);
	}
}

public class Bank {
	Account[] accList = new Account[100];
	int accCnt;

	// 계좌 개설
	void makeAccount(String id, String name, int balance) {
		Account acc = new Account(id, name, balance);
		accList[accCnt++] = acc;
	}

	// 모든 계좌의 정보 출력
	void allAccountInfo() {
		for (int i = 0; i < accCnt; i++) {
			System.out.println(accList[i].info());
		}
	}

	// 계좌번호를 찾아 해당 계좌의 정보 출력
	void accountInfo(String id) {
		Account accList = searchById(id);
		if (accList == null) {
			System.out.println("계좌번호가 틀립니다.");
			return; // 계좌가 맞지 않을 때 처음으로 돌아가기.
		}
		System.out.println(accList.info());
	}

	// 특정 계좌번호에 입금
	void deposit(String id, int money) {
		Account accList = searchById(id);
		if (accList == null) {
			System.out.println("계좌번호가 틀립니다.");
			return; // 계좌가 맞지 않을 때 처음으로 돌아가기.
		}
		accList.balance += money;
	}

	// 특정 계좌번호에 출금
	void withdraw(String id, int money) {
		Account accList = searchById(id);
//		if (accList == null) {
//			System.out.println("계좌번호가 틀립니다.");
//			return;
//		}
		if (accList.balance > money) {
			accList.balance -= money;
		}
	}

	// 특정 계좌번호 찾는 메서드 -> 반복되므로 하나로 정의
	Account searchById(String id) {
		for (int i = 0; i < accCnt; i++) {
			if (accList[i].id.equals(id)) {
				return accList[i];
			}
		}
		return null;
	}

	public static void main(String[] args) {

		// #2 계좌 개설
		Bank bank = new Bank();
		bank.makeAccount("10001", "고길동", 100000);
		bank.makeAccount("10002", "김길동", 200000);

		// 개설된 모든 계좌의 정보 출력
		bank.allAccountInfo();
		// 계좌번호: 10001, 이름: 고길동, 잔액: 100000 출력
		// 계좌번호: 10002, 이름: 김길동, 잔액: 200000 출력

		// 계좌번호가 파라미터와 같은 경우만 출력
		bank.accountInfo("10001");
		// 계좌번호: 10001, 이름: 고길동, 잔액: 100000 출력

		// 계좌번호를 찾아 입금
		bank.deposit("10001", 10000);
		bank.accountInfo("10001");
		// 계좌번호: 10001, 이름: 고길동, 잔액: 110000 출력

		// 계좌번호를 찾아 출금
		bank.withdraw("10001", 5000);
		bank.accountInfo("10001");
		// 계좌번호: 10001, 이름: 고길동, 잔액: 105000 출력
	}
}