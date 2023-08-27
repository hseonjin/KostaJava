package starcraft.main;

import starcraft.item.SCV;
import starcraft.item.Tank;
import starcraft.item.Zerg;

public class StarMain {

	public static void main(String[] args) {
        Tank tank = new Tank();
        SCV scv = new SCV();
        Zerg zerg = new Zerg();
        // Marine marine = new Marine();
        
        // Repairable 인터페이스의 추상 메서드를 생성하어 tank, scv, zerg의 공통된 동작을 수행
        scv.repair(tank); // 90% 회복
        scv.repair(scv); // 80% 회복
        scv.repair(zerg); // 100% 회복
        //scv.repair(marine); // error
	}
}