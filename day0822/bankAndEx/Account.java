package bankAndEx;
public class Account {
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