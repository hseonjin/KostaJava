package properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest3 {

	public static void main(String[] args) {
		Properties prop1 = new Properties();
		Properties prop2 = new Properties();
		try {
			prop1.load(new FileInputStream("setting.txt"));
			System.out.println(prop1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
