package item;

public class Unit {
	int healthPoint;
	final int MAX_HP;

	Unit(int hp) {
		MAX_HP = hp;
		healthPoint = MAX_HP;
	}
}

// final변수는 인스턴스변수 값 또는 생성자를 통해 초기화 필수
// final은 인스턴스 변수
// 