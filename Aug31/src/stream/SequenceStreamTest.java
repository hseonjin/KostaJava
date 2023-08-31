package stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

public class SequenceStreamTest {

	public static void main(String[] args) {
		FileInputStream fis1 = null; // news
		FileInputStream fis2 = null; // text

		FileOutputStream fos = null;

		SequenceInputStream sis = null;
		
		// sequence 파라미터 여러개
		Vector<InputStream> v = new Vector<>();

		try {
			// 파일 여러개 병합
			v.add(new FileInputStream("news.txt"));
			v.add(new FileInputStream("test.txt"));
			sis = new SequenceInputStream(v.elements());
			
//			fis1 = new FileInputStream("news.txt");
//			fis2 = new FileInputStream("test.txt");
//			sis = new SequenceInputStream(fis1, fis2);
			
			fos = new FileOutputStream("total.txt");

			byte[] buff = new byte[1024];
			int len = 0;
			while ((len = sis.read(buff)) > 0) {
				fos.write(buff, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sis != null)
					sis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
