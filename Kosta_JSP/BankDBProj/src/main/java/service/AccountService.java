package service;

import java.util.ArrayList;
import java.util.List;

import dao.AccountDAO;
import dto.Account;

public class AccountService {
	AccountDAO dao = new AccountDAO();
	
	public void makeAccount(Account acc) throws Exception {
		Account sacc = dao.selectAccount(acc.getId());
		if(sacc!=null) throw new Exception("계좌번호가 중복됩니다");
		dao.insertAccount(acc);
	}
	
	// 특정 계좌 조회
	public Account infoAccount(String id) throws Exception {
	    Account acc = dao.selectAccount(id);
	    if (acc == null) {
	        throw new Exception("존재하지 않는 계좌입니다");
	    }
	    return acc;
	}
	
	// 입금
	public Account deposit(String id, Integer money) throws Exception {
		Account acc = dao.selectAccount(id);
		if(acc==null) throw new Exception("존재하지 않는 계좌입니다");
		acc.deposit(money);
		int updateResult = dao.updateAccount(acc);
		return acc;
	}	
	
	// 출금
	public Account withdraw(String id, Integer money) throws Exception {
		Account acc = dao.selectAccount(id);
		if(acc==null) throw new Exception("존재하지 않는 계좌입니다");
		acc.withdraw(money);
		int updateResult = dao.updateAccount(acc);
		return acc;
	}

	// 전체 계좌 조회
	public List<Account> getAllAccounts() {
	    List<Account> accs = new ArrayList<>();

	    List<Account> accDB = dao.selectAllAccounts(); 
	    
	    if (accDB != null && !accDB.isEmpty()) {
	    	accs.addAll(accDB);
	    }
	    return accs;
	}	


    
    // 모든 계좌 정보 조회
//    public List<Account> getAllAccounts() {
//        return dao.selectAllAccounts();
//    }

}
