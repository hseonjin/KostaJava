package ch07;

// 섯다카드의 숫자와 종류(isKwang)는 사실 한번 값이 지정되면 변경되어서는 안 되는 값이다.
// -> private 접근제어자 사용

class SutdaCard2 {
	private int num;
	private boolean isKwang;

	SutdaCard2() {
		this(1, true);
	}

	SutdaCard2(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

class Ex14 {
	public static void main(String args[]) {
		SutdaCard2 card = new SutdaCard2(1, true);
	}
}
