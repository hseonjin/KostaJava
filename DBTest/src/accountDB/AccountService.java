package accountDB;

import java.sql.Connection;
import java.util.List;

public class AccountService {
	public void accountInfo(String id) {
		// Connection을 호출한 곳에서 close() 해주기~
		Connection conn = DAO.getConnection();
		
		// select (DAO의 accountInfo 메소드 활용)
		Account acc = DAO.selectAccount(conn, id);
		if(acc == null) {
			System.out.println("없는 계좌입니다.");
		} else {
			System.out.println(acc);
		}
		
		DAO.close(conn);
	}
	
	public void makeAccount(Account acc) {
		Connection conn = DAO.getConnection();
		Account racc = DAO.selectAccount(conn, acc.getId());
		if(racc != null) {
			System.out.println("중복 계좌번호입니다.");
		} else {
			int cnt = DAO.insertAccount(conn, acc);
			if(cnt>0) {
				System.out.println(cnt + "개 계좌가 개설되었습니다.");
			}
		}
		DAO.close(conn);
	}
	
	public void deposit(String id, Integer money) {
		Connection conn = DAO.getConnection();
		Account acc = DAO.selectAccount(conn, id); // 계좌조회
		if(acc==null) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		acc.deposit(money); // 가져온 계좌에 입금(객체에 입금)
		if(DAO.updateAccount(conn, acc)>0) {
			System.out.println(String.format("%s 계좌에 %d원 입금되었습니다", acc.getId(), acc.getBalance()));
		}
		DAO.close(conn);
	}
	
	public void withraw(String id, Integer money) {
		Connection conn = DAO.getConnection();
		Account acc = DAO.selectAccount(conn, id);
		if(acc==null) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		if(acc.getBalance() < money) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		acc.withdraw(money);
		if(DAO.updateAccount(conn, acc) > 0) {
			System.out.println(String.format("%s 계좌의 잔액은 %d원 입니다.", acc.getId(), acc.getBalance()));
		}
		DAO.close(conn);
	}
	
	public void allAccountInfo() {
		Connection conn = DAO.getConnection();
		List<Account> accs = DAO.selectAccountList(conn);
		for(Account acc : accs) {
			System.out.println(acc);
		}
		DAO.close(conn);
	}
}
