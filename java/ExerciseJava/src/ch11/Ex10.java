package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex10 {
	public static void main(String[] args) {
		Set set = new HashSet();
		int[][] board = new int[5][5];
		for (int i = 0; set.size() < 25; i++) {
			set.add((int) (Math.random() * 30) + 1 + "");
		}
		
		ArrayList list = new ArrayList(set); // 데이터 옮겨 담기
		Collections.shuffle(list); // list의 데이터 순서 섞기
		Iterator it = list.iterator();
//		Iterator it = set.iterator();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String) it.next());
				System.out.print((board[i][j] < 10 ? " " : " ") + board[i][j]);
			}
			System.out.println();
		}
	} // main
}

// HashSet은 중복X, 순서X 이므로 위치가 섞이지 않는다 -> List 사용하기