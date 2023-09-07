package arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Account {
	String id;
	int balance;
	
	Account() {}
	Account(String id, int balance) {
		this.id = id;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return String.format("계좌번호: %s, 잔액: %d", id, balance);
	}
}

// Comparator 상속
class IdCompare implements Comparator<Account> {
	@Override
	public int compare(Account o1, Account o2) {
		return o1.id.compareTo(o2.id); // o1.id인 경우 decending(역순)
	}
}

public class ArrayListTest3 {

	public static void main(String[] args) {
		List<Account> accs = new ArrayList<>();
		accs.add(new Account("10004", 100));
		accs.add(new Account("10002", 300));
		accs.add(new Account("10003", 400));
		
		Collections.sort(accs, new IdCompare()); // 비교할 때 IdCompare을 호출하고,,
		
		// 향상된 for문
//		for(Account acc: accs) {
//			System.out.println(acc);
//		}
		
		for(int i=0; i<accs.size(); i++) { // size(), get() 사용
			System.out.println(accs.get(i));
		}
		
		Iterator<Account> it = accs.iterator(); // 반복자 - 데이터를 하나하나 가져다 쓸 때 사용
		while (it.hasNext()) { // 다음 데이터를 가져오는 것이 hasNext()
			Account acc = it.next();
			System.out.println(acc);
			// 또는 System.out.println(it.next()); 로 한줄로 쓸 수 있다
		}
		
		// 조회만 하는 경우 향상된 for문을 사용하는 것이 가장 효율적
		// 반복자는 중간에 변경되는 경우에도 사용이 가능하다 (삭제나 삽입이 필요한 경우 반복자 사용을 권장)
	}
}