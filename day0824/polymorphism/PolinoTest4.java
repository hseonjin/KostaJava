package polymorphism;

class Car {
	String color;
	int door;
	void drive() {
		System.out.println("drive, Brrr~");
	}
	
	void stop() {
		System.out.println("stop!!");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("Water!!!");
	}
}

class Ambulance extends Car {
	void siren() {
		System.out.println("siren!!!");
	}
}

public class PolinoTest4 {

	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		fe.water();
		
		Car car = fe; // FireEngine 타입을 Car 타입으로 업캐스팅
		// car.water()
		if(car instanceof FireEngine) {
			FireEngine fe2 = (FireEngine) car;
			fe2.water();
		}
	}
}