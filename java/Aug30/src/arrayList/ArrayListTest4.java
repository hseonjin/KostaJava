package arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest4 {
	static void print(List<Integer> list) {
		for(Integer n :list) {
			System.out.print(n + ",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(10);
		list1.add(5);
		list1.add(4);
		list1.add(2);
		list1.add(0);
		list1.add(1);
		list1.add(3);
		
		List<Integer> list2 = list1.subList(1, 4);
		System.out.println(list1);
		System.out.println("-----------------------");

		
		print(list1);
		print(list2);
		
		System.out.println(list1.containsAll(list2)); // list1에 list2가 전부 포함되는지 t/f
		System.out.println("-----------------------");
		
		list1.retainAll(list2); // list1에서 list2만 남기고 모두 삭제
		print(list1);
		System.out.println("-----------------------");

		list1.add(0, 6); // add(index, number) 0번째에 6을 삽입
		print(list1);
		
		list1.set(0, 7); // set(index, number) 0번찌를 7로 변경
		print(list1);
		
		list1.add(7); // 7 삽입
		print(list1);
		
		list1.remove(new Integer(7)); // 중복값이 있는 경우, 첫번째로 나타나는 값을 삭제
		print(list1);

	}
}