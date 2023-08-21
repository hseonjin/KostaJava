package ex6;

class StudaCard {
	int num = 1;
	boolean isKwang = true;

	String info() {
		return num + (isKwang ? "K" : "");
	}
}

public class Ex2 {
	public static void main(String[] args) {
		StudaCard card1 = new StudaCard();
		card1.num = 3;
		card1.isKwang = false;

		StudaCard card2 = new StudaCard();
		System.out.println(card1.info());
		System.out.println(card2.info());

	}
}