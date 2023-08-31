package stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {

	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream("kkomee.jpg");
			fos = new FileOutputStream("kkomee2.jpg");
//			int data;
//			while ((data = fis.read()) != -1) {
//				fos.write(data);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);

			byte[] buff = new byte[1024];
			int len;
//			while((len=fis.read(buff))>0) { // 0도 포함되어야하기 때문에 0보다 크다는 조건을 가져야 함
//				fos.write(buff, 0, len);
			while((len=bis.read(buff))>0) {
				bos.write(buff, 0, len);
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

