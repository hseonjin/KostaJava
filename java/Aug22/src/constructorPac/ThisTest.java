package constructorPac;

class Account {
	String id;
	String name;
	int balance;
	
	Account(String id, String name, int balance) {
		// this를 써서 명시 (지역변수와 똑같은 이름을 가지기 때문에)
		// 인스턴스 변수임을 명확히 알려주려고 할 때 this를 사용해줘
		// 클래스 내 생성자를 가진 메소드에서 사용
		// static 메소드에서 사용 불가
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	String info() {
		return "계좌번호:" + id + ", 이름:" + name + ", 잔액:" + balance;
	}
}

public class ThisTest {

	public static void main(String[] args) {
		Account acc1 = new Account("10001", "홍길동", 100000);		
	}
}
