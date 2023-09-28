package service;

import java.util.List;

import bean.Account;

public interface AccountService {
	// 계좌등록
	void makeAccount(Account acc) throws Exception;
	
	// 계좌조회
	Account accountInfo(String id) throws Exception;
	
	// 입금
	void deposit(String id, Integer money) throws Exception;
	
	// 출금
	void withdraw(String id, Integer money) throws Exception;
	
	// 전체계좌조회
	List<Account> allAccountInfo() throws Exception;
}
