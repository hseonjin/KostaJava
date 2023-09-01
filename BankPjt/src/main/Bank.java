package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import acc.Account;
import acc.SpecialAccount;
import exc.BankError;
import exc.BankException;

public class Bank {
	// Account[] accs = new Account[100];
	// int accCnt;
	// List<Account> accs = new ArrayList<>(); // ArrayList 사용
	Map<String, Account> accs = new HashMap<>();
	Scanner sc = new Scanner(System.in);

	int menu() throws BankException {
		System.out.println("[코스타 은행]");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌조회");
		System.out.println("5. 전체계좌조회");
		System.out.println("0. 종료");
		System.out.print("선택>>");
		int sel = Integer.parseInt(sc.nextLine());

		// 예외처리
		if (!(sel >= 0 && sel <= 5)) {
			throw new BankException("메뉴오류", BankError.MENU); // (msg, errCode) msg: "잘못 선택했습니다."
		}
		return sel;
	}

	void selAccMenu() throws BankException {
		System.out.println("[계좌개설]");
		System.out.println("1.일반계좌");
		System.out.println("2.특수계좌");
		System.out.print("선택>>");
		int sel = Integer.parseInt(sc.nextLine());
		switch (sel) {
		case 1:
			makeAccount();
			break;
		case 2:
			makeSpecialAccount();
			break;
		default:
			// 예외처리
			throw new BankException("메뉴오류", BankError.MENU);
		}
	}

	void makeAccount() throws BankException {
		System.out.println("[일반계좌 개설]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
//		Account acc = searchAccById(id);

		// 예외처리
//		if (acc != null) {
//			throw new BankException("계좌오류", BankError.EXISTID); // msg: "계좌번호가 중복됩니다"
//		}
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("입금액:");
		int money = Integer.parseInt(sc.nextLine());
//		accs.add(new Account(id, name, money)); // ArrayList 사용
		accs.put(id, new Account(id, name, money)); // HashMap 사용

//		accs[accCnt++]=new Account(id,name,money);
	}

	void makeSpecialAccount() throws BankException {
		System.out.println("[특수계좌 개설]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
//		Account acc = searchAccById(id);

//		// 예외처리
//		if (acc != null) {
//			throw new BankException("계좌오류", BankError.EXISTID);
//		}
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("입금액:");
		int money = Integer.parseInt(sc.nextLine());
		System.out.print("등급(VIP-V,Gold-G,Silver-S,Normal-N):");
		String grade = sc.nextLine();
		// 추가
//		accs.add(new SpecialAccount(id, name, money, grade));	// ArrayList 사용

		accs.put(id, new SpecialAccount(id, name, money, grade));
//		accs[accCnt++]=new SpecialAccount(id,name,money,grade);

//	Account searchAccById(String id) {
		/*
		 * for(int i=0; i<accs.size(); i++) { if(accs.get(i).getId().equals(id)) {
		 * return accs[i]; } }
		 */
		// 향상된 for문 사용
//		for(Account acc : accs) {
//			if(acc.getId().equals(id)) return acc;
//		}
//		return null;
	}

	void deposit() throws BankException {
		System.out.println("[입금]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
//		Account acc = searchAccById(id);

//		// 예외처리
//		if(acc==null) {
//			throw new BankException("계좌오류", BankError.NOID); // msg: "계좌번호 오류입니다."
//		}
//		System.out.print("입금액:");
//		int money = Integer.parseInt(sc.nextLine());
//		acc.deposit(money);
		// 예외처리 HashMap
		if (!accs.containsKey(id)) {
			throw new BankException("계좌오류", BankError.NOID); // msg: "계좌번호 오류입니다."
		}
		System.out.print("입금액:");
		int money = Integer.parseInt(sc.nextLine());
//		Account acc = accs.get(id);
//		acc.deposit(money);
		accs.get(id).deposit(money);
	}

	void withdraw() throws BankException {
		System.out.println("[출금]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
//		Account acc = searchAccById(id);

		// 예외처리
		if (!accs.containsKey(id)) {
			throw new BankException("계좌오류", BankError.NOID);
		}
		System.out.print("출금액:");
		int money = Integer.parseInt(sc.nextLine());
		accs.get(id).withdraw(money);
	}

	void accountInfo() throws BankException {
		System.out.println("[계좌조회]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
//		Account acc = searchAccById(id);

		// 예외처리
		if (!accs.containsKey(id))
			throw new BankException("계좌오류", BankError.NOID);
//		System.out.println(acc);
		System.out.println(accs.get(id));
	}

	void allAccountInfo() {
		System.out.println("[전체 계좌 조회]");
		/*
		 * for(int i=0; i<accCnt; i++) { System.out.println(accs[i]); }
		 * 
		 * 향상된 for문 for(Account acc: accs) System.out.println(acc);
		 */
//		Iterator<Account> it = accs.iterator(); 	// ArrayList 사용
		Iterator<Account> it = accs.values().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	// stream
	public void store_b() {
		DataOutputStream dao = null;
		try {
			dao = new DataOutputStream(new FileOutputStream("accs.bin"));
			dao.writeInt(accs.size()); // 계좌 갯수 저장
			for (Account acc : accs.values()) {
				if (acc instanceof SpecialAccount) {
					dao.writeChar('S');
				} else {
					dao.writeChar('N');
				}
				dao.writeUTF(acc.getId()); // 계좌번호
				dao.writeUTF(acc.getName()); // 이름
				dao.writeInt(acc.getBalance()); // 잔액
				if (acc instanceof SpecialAccount) {
					dao.writeUTF(((SpecialAccount) acc).getGrade()); // 등급
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dao != null)
					dao.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 저장
	public void store_t() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("accs.txt"));
			for (Account acc : accs.values()) {
				String accStr = acc.getId();
				accStr += "," + acc.getName();
				accStr += "," + acc.getBalance();
				if (acc instanceof SpecialAccount) { // SpecialAccount일 떄만 grade까지!
					accStr += "," + ((SpecialAccount) acc).getGrade().charAt(0);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 읽기
	public void load_t() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("accs.txt"));
			String accStr = null;
			while((accStr=br.readLine())!=null) {	
				StringTokenizer st = new StringTokenizer(accStr, ",");
				String id = st.nextToken();
				String name = st.nextToken();
				int balance = Integer.parseInt(st.nextToken());
				if(st.countTokens()!=0) {
					String grade = st.nextToken();
					accs.put(id,  new SpecialAccount(id, name, balance, grade));
				} else {
					accs.put(id, new Account(id, name, balance));
				}
//				String[] accProp = accStr.split(","); // "," 구분자로 요소 분리
//				String id = accProp[0];
//				String name = accProp[1];
//				int balance = Integer.parseInt(accProp[2]);
//				if(accProp.length==4) {
//					String grade = accProp[3];
//					accs.put(id,  new SpecialAccount(id, name, balance, grade));
//				} else {
//					accs.put(id, new Account(id, name, balance));
//				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) br.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void load_b() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("accs.bin"));
			int count = dis.readInt(); // 계좌 갯수
			for (int i = 0; i < count; i++) {
				char sect = dis.readChar(); // 계좌종류 구분값
				String id = dis.readUTF(); // 계좌번호
				String name = dis.readUTF(); // 이름
				int balance = dis.readInt(); // 잔액
				if (sect == 'S') {
					String grade = dis.readUTF(); // 등급
					// 사용자 입력은 한 번, 보여줄 떈 그대로
					accs.put(id, new SpecialAccount(id, name, balance, grade));
				} else {
					accs.put(id, new Account(id, name, balance));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null)
					dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void store_s() {
		ObjectOutputStream oos = null;
		try {
			oos =  new ObjectOutputStream(new FileOutputStream("accs.dat"));
			oos.writeObject(accs);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos!=null) oos.close();;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void load_s() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("accs.dat"));
			accs = (Map<String, Account>) ois.readObject();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try { 
				if(ois!=null) ois.close();
			}  catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Bank bank = new Bank();
		int sel;
		while (true) {
			// 예외처리 (위임받아 main() 메소드에서 처리)
			try {
				sel = bank.menu();
				if (sel == 0) {
					bank.store_b();
					break;
				}
				switch (sel) {
				case 1:
					bank.selAccMenu();
					break;
				case 2:
					bank.deposit();
					break;
				case 3:
					bank.withdraw();
					break;
				case 4:
					bank.accountInfo();
					break;
				case 5:
					bank.allAccountInfo();
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("입력형식이 맞지 않습니다. 다시 선택하세요.");
			} catch (BankException e) {
				System.out.println(e);
			}
		}
	}
}