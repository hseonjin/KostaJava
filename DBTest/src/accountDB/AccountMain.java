package accountDB;

public class AccountMain {

	public static void main(String[] args) {
		AccountService service = new AccountService();
		
		// 계좌 조회
//		service.accountInfo("10001");
		
		// 계좌 개설
//		Account acc = new Account("10004", "탁길동", 300000, "VIP");
//		service.makeAccount(acc);
		
		// 입금
//		service.deposit("10004", 200);
		
		// 출금
//		service.withraw("10004", 200);
		
		// 전체 계좌 조회
		service.allAccountInfo();
	}
}