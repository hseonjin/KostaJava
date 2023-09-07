package arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest6 {
	

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9)); // 데이터를 하나하나 넣지 않고 한번에 설정
		System.out.println(numbers);
		numbers.removeIf(n->(n%3)==0); // 람다식, 3의 배수일 때 remove 
		System.out.println(numbers);
	}
}