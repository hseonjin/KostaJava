package companyElement;

public class Sales extends Permanent{
	int incentive;
	
	// getter,setter
	public int getIncentive() {
		return incentive;
	}
	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}

	// 생성자
	public Sales() {}
	public Sales(int id, String name, int salary, int incentive) {
		super(id, name, salary);
		this.incentive = incentive;
	}
	
	// method
	@Override
	public int getPay() {
		return super.getPay() + getIncentive();
	}
}
