package stream;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Person {
	String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	int age;
	double height;
	boolean married;

	Person(String name, int age, double height, boolean married) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.married = married;
	}

	@Override
	public String toString() {
		return String.format("이름 : %s , 나이 : %d , 키 : %f , 결혼 : %s", name, age, height, (married ? "Y" : "N"));
	}
}

public class DataStreamTest {
	static void write(Person p) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {
			fos = new FileOutputStream("person.bin");
			dos = new DataOutputStream(fos);
			dos.writeUTF(p.name);
			dos.writeInt(p.age);
			dos.writeDouble(p.height);
			dos.writeBoolean(p.married);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static Person read() {
		FileInputStream fis = null;
		DataInputStream dis = null;
		Person p = null;
		try {
			fis = new FileInputStream("person.bin");
			dis = new DataInputStream(fis);

			String name = dis.readUTF();
			int age = dis.readInt();
			double height = dis.readDouble();
			boolean married = dis.readBoolean();
			p = new Person(name, age, height, married);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

	static void write(List<Person> pers) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {
			fos = new FileOutputStream("person.bin");
			dos = new DataOutputStream(fos);
			dos.writeInt(pers.size()); // 인원수 저장
			for (Person p : pers) {

				dos.writeUTF(p.name);
				dos.writeInt(p.age);
				dos.writeDouble(p.height);
				dos.writeBoolean(p.married);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 읽은걸 다시 쓸 때 몇명인지 정확하게 알 수 없기 때문에 저장할때 person.size()를 저장해준다.
	static List<Person> readList() {
		List<Person> pers = new ArrayList<>();
		FileInputStream fis = null;
		DataInputStream dis = null;
		Person p = null;
		try { // write, read 쌍과 순서 맞춰주어야 함 // 
			fis = new FileInputStream("person.bin");
			dis = new DataInputStream(fis);
			int count = dis.readInt(); // 인원수 저장, 읽어 올 때 몇 번 읽어올지 알려주는 역할	
			for (int i = 0; i < count; i++) {
				String name = dis.readUTF();
				int age = dis.readInt();
				double height = dis.readDouble();
				boolean married = dis.readBoolean();
				pers.add(new Person(name, age, height, married));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pers;
	}

	public static void main(String[] args) {

		// 하나씩 읽고 쓰기
//	      Person p1 = new Person("koko",35,177,false);
//	      write(p1);
//	      
//	      
//	      Person p = read();
//	      System.out.println(p);

		// 목록으로 읽고 쓰기
		List<Person> pers = new ArrayList<>();

		pers.add(new Person("koko", 35, 177.5, false));
		pers.add(new Person("soso", 40, 183.4, false));
		pers.add(new Person("nana", 20, 170.3, true));
		write(pers);

		List<Person> per = readList();
		for (Person p : per) {
			System.out.println(p);
		}

	}

}