package interfacePac;

class MyArray { // singleton Object
	private int[] arr = new int[10];
	private static MyArray myArray; // 유일해야하며, static 메서드에서 사용하기 위해 static변수 선언
	private MyArray() {}
	public static MyArray getMyArrayReference() {
		if(myArray == null) {
			myArray = new MyArray();
		}
		return myArray;
		//return new MyArray(); (X), private를 사용하는 이유(싱글톤)(하나를 가지고 매번 만드는겨)
		// 인스턴스가 오직 1개만 생성되어야 하는 경우 사용하는 패턴
	}
	
	public void setData(int idx, int data) {
		arr[idx] = data;
	}
	
	public int getData(int idx) {
		return arr[idx];
	}
}

public class PrivateConstructor {

	public static void main(String[] args) {
		MyArray ma1 = MyArray.getMyArrayReference();
		MyArray ma2 = MyArray.getMyArrayReference();
		System.out.println(ma1==ma2);
		ma1.setData(0, 100);
		System.out.println(ma2.getData(0));
	}

}

//생성자는 new연산자에 의해 자동 생성, private은 외부에서 사용할 수 없다
// static 객체 생성없이도 호출할 수 있도록 (메소드 안에서 생성하고, 가져오기) 하나를 같이 공유..?
