package service;

import java.util.List;

import bean.Account;
import dao.AccountDAO;
import dao.AccountDAOImpl;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDao; // AccountDAO 인터페이스의 구현체를 참조할 수 있는 참조 변수
	
	public AccountServiceImpl() { // 생성자에서 AccountDAOImpl 인스턴스를 생성하여 멤버 변수에 할당
		accountDao = new AccountDAOImpl();
	}
	
	// 계좌등록
	@Override
	public void makeAccount(Account acc) throws Exception {
		accountDao.insertAccount(acc);
	}

	// 계좌조회
	@Override
	public Account accountInfo(String id) throws Exception {
		return accountDao.selectAccount(id);
	}

	// 입금
	@Override
	public void deposit(String id, Integer money) throws Exception {
		Account acc = accountDao.selectAccount(id);
		if(acc==null) throw new Exception("계좌번호 오류");
		acc.deposit(money);
		accountDao.updateBalance(acc);
		
	}
	// 출금
	@Override
	public void withdraw(String id, Integer money) throws Exception {
		Account acc = accountDao.selectAccount(id);
		if(acc==null) throw new Exception("계좌번호 오류");
		acc.withdraw(money);
		accountDao.updateBalance(acc);
	}

	// 전체계좌조회
	@Override
	public List<Account> allAccountInfo() throws Exception {
		return accountDao.selectAccountList();
	}
}
