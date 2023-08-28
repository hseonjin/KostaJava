package pac;

public class Number {
	// private
	private int pnum;
//	private void pmethod() {
//		pnum = 10;
//	}
	
	// default
	int dnum;
//	public int getDnum() {
//		return dnum;
//	}
//	public void setDnum(int data) {
//		dnum = data;
//	}

	public int getDnum() {
		return dnum;
	}
	public void setDnum(int dnum) {
		this.dnum = dnum;
	}
	
	
	public void dmethod() {
		System.out.println(pnum);
	}
	
	// public
	public int punum;
	public void pumethod() {
		System.out.println(pnum);
	}
}
