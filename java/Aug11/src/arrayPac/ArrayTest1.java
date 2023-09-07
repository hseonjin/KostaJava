package arrayPac;

public class ArrayTest1 {

	public static void main(String[] args) {
		// �ַ� ù��°ó�� ���
		int[] arr; // arr�� �迭�� �����ϴ� �ּҰ�(4byte)�� ��Ÿ��
		int arr1[];
		
		int[] narr1 = new int[5]; // �ϳ��� 4����Ʈ ����
		double[] daar1 = new double[5]; // �ϳ��� 8����Ʈ ����

//			narr1[0] = 1;
//			narr1[1] = 2;
//			narr1[2] = 3;
//			narr1[3] = 4;
//			narr1[4] = 5;

		int sum = 0;
		for (int i = 0; i < narr1.length; i++) {
			sum += narr1[i];
		}
		System.out.println(sum);
	}

}
