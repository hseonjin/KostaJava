package pac;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.util.Scanner;

public class MyClass {
		Scanner sc = new Scanner(System.in);
		
		// 클래스명이 같고, 다른 패키지에 있는 경우 -> 하나는 import, 하나는 패키지명 작성하며 사용
		public Date date;
		java.util.Date date2;
		
		FileReader fr;
		FileWriter fw;
		
		public MyClass() {}
}
