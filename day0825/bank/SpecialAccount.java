package bank;

public class SpecialAccount extends Account2{
	String grade;
	
	SpecialAccount(String id, String name, int money, String grade) {
		super(id, name, money);
		this.grade = grade;
	}
	
	public void deposit(int i) {
		if(grade.equals("V")) {
			this.balance += i + (i*0.04);
		} else if(grade.equals("G")) {
			this.balance += i + (i*0.03);
		} else if(grade.equals("S")) {
			this.balance += i + (i*0.02);
		} else {
			this.balance += i + (i*0.01);
		}
	}
	
	@Override
	String info() {
		return super.info() + ", 등급: " + grade;
	}

}