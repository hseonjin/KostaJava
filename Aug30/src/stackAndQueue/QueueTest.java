package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest { // queue : First In First Out

	public static void main(String[] args) {
		Queue queue = new LinkedList<>(); // Queue 인터페이스의 구현체인 LinkedList 사용
		// 객체 추가 => offer: 실패하면 false 반환, add: 실패하면 IllegalstateException 발생
		queue.offer(100); // enqueue
		queue.offer(200);
		queue.add(300);
		queue.add(400);

		System.out.println(queue.poll()); // 요소 반환
		System.out.println(queue.poll()); 
		System.out.println(queue.remove()); // 삭제
		queue.clear(); // 초기화
	}
}