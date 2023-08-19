package variable;

public class MyInfo {

	public static void main(String[] args) {
		// 이름을 저장할 변수를 선언하여 본인 이름 할당
		String name = "허선진";
		// 나이를 저장할 변수를 선언하여 본인 나이 할당
		int age = 24;
		// 키를 저장할 변수를 선언하여 본인키 소숫점까지 할당
		float length = 157.4f;
		// 남여를 구분할 수 있는 변수를 선언하여 본인 성별 할당 'F or M'
		char gender = 'F';

		// 선언한 변수 출력
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + length);
		System.out.println("성별 : " + gender);
	}

}
