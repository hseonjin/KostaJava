package dao;

import java.util.List;

import bean.Account;

public interface AccountDAO {
	// 계좌등록
	void insertAccount(Account acc) throws Exception;
	
	// 계좌조회
	Account selectAccount(String id) throws Exception;
	
	// 입출금
	void updateBalance(Account acc) throws Exception;
	
	// 전체계좌조회
	List<Account> selectAccountList() throws Exception;
}
