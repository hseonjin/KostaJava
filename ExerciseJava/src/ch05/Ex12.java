package ch05;

public class Ex12 {

	public static void main(String[] args) {
		// �߰�����
		// 3m ¥�� �칰 �ٴڿ� �����̰� �ִ�.
		// �����̴� ������ 55cm�� �ö� �� �ְ�, ���� ���� ���� �ڴ� ���� 3cm �̲����� �����´�.
		// �����̰� �칰 ������ ������ �� ��ĥ�� �ɸ��°�
		// �ݺ����� ���ǹ��� �̿��Ͽ� ���α׷� �ۼ�

		int well = 300;
		int days = 0;
		int up = 0;

		while (true) {
			up += 55; // ������ 55cm �ö�
			days += 1; // �ö󰡰� �ذ� ���� �Ϸ簡 ������
			if (up >= well) { // �ö� ���̰� �칰 ���� �̻��� �Ǹ�
				break; // ���߱�
			} else { // �칰 ���� �̻��� ���� ������
				up -= 3; // 3cm �̲����� ������
			}
		}
		System.out.println(days);
	}
}

//int depth = 3*100; // �칰�� ����
//int height = 0; // �ö� ����
//final int up = 55; // �ö� �� �ִ� ����
//final int down = 3; // �̲������� ����
//int day = 0; // �ɸ� ��¥��

//while(true) {
//	height += up;
//	days++;
//	if(depth<=height) break;
//	height -= down;
//}
