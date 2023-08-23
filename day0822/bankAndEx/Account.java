package bankAndEx;
public class Account {
	String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	String name;
	int balance;
	
	// 생성자 만들기
	public Account(String aid, String aname, int money) {
		id = aid;
		name = aname;
		balance = money;
	}

	public String info() {
		return String.format("계좌번호: %s, 이름: %s, 잔액: %d", id, name, balance);
	}

	public void deposit(int i) {
		balance += i;
	}

	public void withdraw(int i) {
		if (balance >= i) {
			balance -= i;
		}
	}
}