package ch07;

// 섯다카드 20장을 포함하는 섯다카드 한 벌(SutdaDeck클래스)을 정의한 것이다.
// 섯다카드 20장을 담는 SutdaCard배열을 초기화하시오.
// 단, 섯다카드는 1부터 10까지의 숫자가 적힌 카드가 한 쌍씩 있고, 숫자가 1, 3, 8인 경우에는 둘 중의 한 장은 광(Kwang)이어야 한다.
// 즉, SutdaCard의 인스턴스변수 isKwang의 값이 true이어야 한다.

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		// (1) 배열 SutdaCard를 적절히 초기화 하시오.
		for (int i = 0; i < CARD_NUM; i++) {
			if (i == 0 || i == 2 || i == 7) {
				cards[i] = new SutdaCard(i + 1, true);
			} else {
				cards[i] = new SutdaCard(i % 10 + 1, false);
			}
		}
//		int length = CARD_NUM / 2;
//		for (int i = 0; i < CARD_NUM; i++) {
//			if (i == 0 || i == 2 || i == 7) {
//				cards[i] = new SutdaCard(i + 1, true);
//			} else {
//				cards[i] = new SutdaCard(i + 1, false);
//			}
//			cards[10+i] = new SutdaCard(i+1, false);
//		}
	}

	void shuffle() {
//		int idx = 0;
//		for (int i = 0; i < 1000; i++) {
//			idx = (int) (Math.random() * CARD_NUM);
//			SutdaCard tmp = cards[idx];
//			cards[idx] = cards[i];
//			cards[i] = tmp;
//		}
		
//		/*
		for (int i = 0; i < 1000; i++) {
			int idx1 = (int)(Math.random()*CARD_NUM);
			int idx2 = (int)(Math.random()*CARD_NUM);
			SutdaCard tmp = cards[idx1];
			cards[idx1] = cards[idx2];
			cards[idx2] = tmp;
		}
//		 */
	}

	public SutdaCard pick(int index) {
		return cards[index];
	}

	SutdaCard pick() {
		int idx = (int) (Math.random() * CARD_NUM);
		return cards[idx];
	}

}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	// info()대신 Object클래스의 toString()을 오버라이딩했다.
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

class Ex1_2 {
	public static void main(String args[]) {
		SutdaDeck deck = new SutdaDeck();
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");
		System.out.println();
		System.out.println(deck.pick(0));
	}
}