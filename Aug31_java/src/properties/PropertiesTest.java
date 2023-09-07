package properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("name", "hong gil dong");
		prop.setProperty("age", "30");
		prop.setProperty("height", "178.5");
		prop.setProperty("weight", "77");
		
		try {
			prop.store(new FileOutputStream("profile.properties"), "profile");
			prop.storeToXML(new FileOutputStream("profile.xml"), "profile");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}