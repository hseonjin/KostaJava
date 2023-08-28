package acc;

import exc.BankError;
import exc.BankException;

public class Account {
	String id;
	String name;
	int balance;
	
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
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	// 생성자
	public Account() {}
	public Account(String id, String name, int money) {
		this.id = id;
		this.name = name;
		this.balance = money;
	}
	
	// 메소드
	@Override
	public String toString() {
		return String.format("계좌번호:%s,이름:%s,잔액:%d", id,name,balance);
	}
	
	// 예외처리
	public void deposit(int money) throws BankException {
		if(money<=0) {
			throw new BankException("입금오류",BankError.MINUS);
		}
		balance += money;
	}
	
	// 예외처리
	public void withdraw(int money) throws BankException {
		if(balance<money) {
			throw new BankException("출금오류",BankError.LACK);
		}
		balance-=money;
	}
}
