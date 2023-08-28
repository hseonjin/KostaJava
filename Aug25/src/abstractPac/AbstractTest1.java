package abstractPac;

abstract class Player {
	int currentPos;
	public Player() {
		currentPos = 0;
	}
	abstract void play(int pos);
	abstract void stop();
	void play() {
		play(currentPos);
	}
}

class DPlayer extends Player{
	// 상속받은 abstract class에서 abstract method를 구현하지 않으면,
	// 상속받은 자식 클래스도 abstract class여야 한다.
	
	// 추상메소드를 오버라이딩 하여 구현하거나, 추상클래스로서 사용하는 방법이 있음
	
	@Override
	void play(int pos) {
		System.out.println("DPlayer play(int pos)");
	}

	@Override
	void stop() {
		System.out.println("DPlayer stop()");
	} 
}

public class AbstractTest1 {

	public static void main(String[] args) {
		// Player player = new Player(); // abstract class는 객체 샏성 불가능
		DPlayer dPlayer = new DPlayer();
		dPlayer.play(10); // 또는 dPlayer.play()
		dPlayer.stop();
		
		Player player = new DPlayer(); // upcasting
		player.play(10); // 또는 player.play()
		player.stop();
		
	}

}
