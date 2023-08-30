package ch11;

import java.util.*;

class Ex02 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7); // list => 3,6,2,2,2,7
		
		HashSet set = new HashSet(list); // set => 3,6,2,7
		TreeSet tset = new TreeSet(set); // tset => 2,3,6,7
		Stack stack = new Stack(); 
		
		stack.addAll(tset); // stack => 2,3,6,7
		
		while (!stack.empty())
			System.out.println(stack.pop()); // 7,6,3,2
	}
}