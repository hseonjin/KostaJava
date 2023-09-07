package ch09;

public class Ex03 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.5\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		
		System.out.println("1번 방법");
		
		System.out.println("fullPath:" + fullPath);
		System.out.println("path:" + fullPath.substring(0, 14));
		System.out.println("fileName:" + fullPath.substring(15));
		
		System.out.println();
		System.out.println("2번 방법");
		int index = fullPath.lastIndexOf("\\");
		if (index != -1) { // 해당 문자열이 없으면 -1 반환하므로 조건문 걸어줌
			path = fullPath.substring(0, index);
			fileName = fullPath.substring(index+1);
		}
		
		System.out.println("fullPath:"+fullPath);
		System.out.println("path:"+path);
		System.out.println("fileName:"+fileName);
	}
}
