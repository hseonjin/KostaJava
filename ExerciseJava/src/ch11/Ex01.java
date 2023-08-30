package ch11;

import java.util.ArrayList;

//다음은 정수집합 1,2,3,4와 3,4,5,6의 교집합, 차집합, 합집합을 구하는 코드이다
// [Hint] ArrayList클래스의 addAll(), removeAll(), retainAll()을 사용하라.

class Ex01{
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList(); // 교집합
		ArrayList cha = new ArrayList(); // 차집합
		ArrayList hap = new ArrayList(); // 합집합
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		// 교집합
		kyo.addAll(list1); // 모두 추가
		kyo.retainAll(list2); // 포함하지 않는 것 삭제
		
		// 차집합
		cha.addAll(list1); 
		cha.removeAll(list2); // 공통된 요소 모두 삭제
		
		
		// 합집합
		hap.addAll(list1); 
		hap.removeAll(kyo);
		hap.addAll(list2); 
		
		
		System.out.println("list1=" + list1);
		System.out.println("list2=" + list2);
		System.out.println("kyo=" + kyo);
		System.out.println("cha=" + cha);
		System.out.println("hap=" + hap);
	}
}