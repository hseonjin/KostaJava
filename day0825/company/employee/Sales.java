package company.employee;

public class Sales extends Permanent implements BusinessTrip {
	int incentive; // 인센티브

	public int getIncentive() {
		return incentive;
	}

	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}

	public Sales() {
	}

	public Sales(int id, String name, int salary, int incentive) {
		super(id, name, salary);
		this.incentive = incentive;
	}

	@Override
	public int getPay() {
		return super.getPay() + getIncentive();
	}

	// 인터페이스에 있는 메서드 오버라이딩 후 하루당 300,000원을 인센티브로 지급
	@Override
	public void reBusinessTrip(int n) {
		setIncentive(getIncentive() + 300000 * n);
	}
}
