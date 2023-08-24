package ch07;


// [7-19] 다음은 물건을 구입하는 사람을 정의한 Buyer클래스이다. 
// 이 클래스는 멤버변수 로 돈(money)과 장바구니(cart)를 가지고 있다. 
// 제품을 구입하는 기능의 buy메서드와 장 바구니에 구입한 물건을 추가하는 add메서드, 구입한 물건의 목록과 사용금액, 
// 그리고 남 은 금액을 출력하는 summary메서드를 완성하시오.

public class Ex19 {

	public static void main(String args[]) {
		Buyer b = new Buyer();
		b.buy(new Tv2());
		b.buy(new Computer());
		b.buy(new Tv2());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		b.summary();
	}
}

class Buyer {
	int money = 1000;
	Product2[] cart = new Product2[3]; // 구입한 제품을 저장하기 위한 배열
	int i = 0; // Product2배열 cart에 사용될 index

	void buy(Product2 p) {
	// 1.1 가진 돈과 물건의 가격을 비교해서 가진 돈이 적으면 메서드를 종료한다. 
	// 1.2 가진돈이 충분하면, 제품의 가격을 가진 돈에서 빼고 
	// 1.3 장바구니에 구입한 물건을 담는다.(add메서드 호출) 
		if(money < p.price) {
			System.out.println("잔액이 부족하여 " + p.toString() + "을/를 살 수 없습니다.");
			return;
		} else {
			money -= p.price;
			add(p);
		}
	}

	void add(Product2 p) {
	// 1.1 i의 값이 장바구니의 크기보다 같거나 크면 
	// 	1.1.1 기존의 장바구니보다 2배 큰 새로운 배열을 생성한다. 
	// 	1.1.2 기존의 장바구니의 내용을 새로운 배열에 복사한다. 
	// 	1.1.3 새로운 장바구니와 기존의 장바구니를바꾼다. 
	// 1.2 물건을 장바구니(cart)에 저장한다. 그리고 i의 값을 1 증가시킨다.
		Product2[] newCart;
		if (i >= cart.length) {
			newCart = new Product2[cart.length*2];
			System.arraycopy(cart, 0, newCart, 0, i); // i? cart.length?
			cart = newCart;
		}
		cart[i++] = p;

	} // add(Product2 p)

	void summary() {
	// 1.1 장바구니에 담긴 물건들의 목록을 만들어 출력한다. 
	// 1.2 장바구니에 담긴 물건들의 가격을 모두 더해서 출력한다.
	// 1.3 물건을 사고 남은 금액(money)를 출력한다.
		int tot = 0;
		String pname = "";
//		System.out.print("구입한 물건: ");
		
		for(int k=0; k<cart.length; k++) {
//			System.out.print(cart[k].toString() + ",");
			tot += cart[k].price;
			pname += cart[k].toString() + ",";
		}
		System.out.println("구입한 물건: " + pname + "\n사용한 금액: " + tot + "\n남은 금액: " + money);

	} // summary()
}

class Product2 {
	int price; // 제품의 가격

	Product2(int price) {
		this.price = price;
	}
}

class Tv2 extends Product2 {
	Tv2() {
		super(100);
	}

	public String toString() {
		return "Tv2";
	}
}

class Computer extends Product2 {
	Computer() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

class Audio extends Product2 {
	Audio() {
		super(50);
	}

	public String toString() {
		return "Audio";
	}

}
