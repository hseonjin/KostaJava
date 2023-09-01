package fileTest;

import java.io.File;

public class FileTest2 {
	public static void main(String[] args) {

		File f = new File("D:\\KOSTA");
		if(!f.exists() || !f.isDirectory()) {
			return;
		}
		
//		String[] files = f.list();
//		for(String file : files) {
//			System.out.println(file);
//		}
		
		File[] files = f.listFiles();
		int totlength= 0;
		for (File file : files) 
			if(file.isDirectory()) {System.out.println("[" + file.getName() + "]");
			System.out.println(file.isDirectory()? "[" + file.getName() + "]" : file.getName());
			
		}
			System.out.println(totlength);

	}
}
