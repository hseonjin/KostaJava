package bank;

public class SpecialAccoutnAnswer extends Account2{
	String grade = "Normal"; // 기본값
	double interest; // 이자

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		switch(grade) {
		case "V":
		case "v": this.grade = "VIP"; interest=0.04; break;
		case "G":
		case "g": this.grade = "Gold"; interest=0.03; break;
		case "S":
		case "s": this.grade = "Silver"; interest=0.02; break;
		case "N":
		case "n": this.grade = "Normal"; interest=0.01; break;
		}
	}
	
	public SpecialAccoutnAnswer(String id, String name, int money, String grade) {
		super(id, name, money);
		this.grade = grade;
	}
	
	@Override
	void deposit(int money) {
		super.deposit((int)Math.round(money+money*interest));
	}

	@Override
	String info() {
		return super.info() + ", 등급: " + grade;
	}
}
