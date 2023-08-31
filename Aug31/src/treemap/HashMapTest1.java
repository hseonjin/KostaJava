package treemap;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest1 {
	public static void main(String[] args) {
		Map<String, Integer> hmap = new HashMap<>();
		hmap.put("1001", 35); // 데이터 삽입(k, v)
		if (hmap.containsKey("1001") == false) { // Key 중복 -> 값이 변경됨, 중복 방지를 위해 확인해주는 과정
			hmap.put("1001", 40);
		}
		hmap.put("1002", 20);
		hmap.put("1003", 33);
		hmap.put("1004", 27);

		Integer value = hmap.get("1001"); // key로 value 조회
		System.out.println(value);

		System.out.println("----");
		for (Integer n : hmap.values()) { // value 전체 목록 조회
			System.out.println(n);
		}

		System.out.println("----");
		for (String k : hmap.keySet()) { // key 전체 목록 조회, hash는 순서대로 가져오지 않음
			System.out.println(k);
		}

		System.out.println("----");
		for (String k : hmap.keySet()) { // key 전체 목록을 통해
//			System.out.println(hmap.get(k)); // value 조회
			System.out.println(String.format("key:%s, value: %d", k, hmap.get(k)));
		}

		System.out.println("----");
		for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
			System.out.println(String.format("key:%s, value: %d", entry.getKey(), entry.getValue()));
		}

	}
}
