package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferedTest1 {

	// Write 하나
	static void write(Person p) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("per.txt");
			bw = new BufferedWriter(fw);
			String perStr = p.getName() + "," + p.getAge() + "," + p.getHeight() + "," + p.isMarried();
			perStr += p.isMarried() ? "Y" : "N";
			bw.write(perStr);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Read 하나
	static Person read() {
		FileReader fr = null;
		BufferedReader br = null;
		Person per = null;
		try {
			fr = new FileReader("per.txt");
			br = new BufferedReader(fr);
			String perStr = br.readLine(); // 받아온 값 koko35177.5Y
			String[] perProp = perStr.split(","); // "," 구분자로 요소 분리
			String name = perProp[0];
			int age = Integer.parseInt(perProp[1]);
			double height = Double.parseDouble(perProp[2]);
			boolean married = perProp[3].charAt(0) == 'Y' ? true : false;
			per = new Person(name, age, height, married);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return per;
	}

	// Write 여러개
	static void write(List<Person> pers) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("pers.txt"));
			for (Person p : pers) {
				String perStr = p.getName() + "," + p.getAge() + "," + p.getHeight() + "," + p.isMarried();
				perStr += p.isMarried() ? "Y" : "N";
				bw.write(perStr);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Read 여러개
	static List<Person> readList() {
		List<Person> pers = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("pers.txt"));
			String perStr = null;
			while((perStr=br.readLine())!=null) {	
				String[] perProp = perStr.split(","); // "," 구분자로 요소 분리
				String name = perProp[0];
				int age = Integer.parseInt(perProp[1]);
				double height = Double.parseDouble(perProp[2]);
				boolean married = perProp[3].charAt(0) == 'Y' ? true : false;
				pers.add(new Person(name, age, height, married));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pers;
	}

	public static void main(String[] args) {
		// 저장하기 (하나)
//		Person p = new Person("hong", 30, 178.5, false);
//		write(p);
		// 읽기
//		Person p = read();
//		System.out.println(p);

		// 저장하기 (여러개)
//		List<Person> pers = new ArrayList<>();
//		pers.add(new Person("hong", 20, 173.5, false));
//		pers.add(new Person("koko", 35, 177.5, false));
//		pers.add(new Person("soso", 40, 183.4, false));
//		pers.add(new Person("nana", 20, 170.3, true));
//		write(pers);
		
		// 읽기 (여러개)
		List<Person> list = readList();
		for(Person p: list) {
			System.out.println(p);
		}

	}

}

//koko35177.5Y
//soso40183.4N
//nana20170.3Y
// ->> 구분자 넣어 문자열로 출력
//koko, 35, 177.5, Y
//soso, 40, 183.4, N
//nana, 20, 170.3, Y