package forWhile;

import java.util.Scanner;

public class DoWhileTest {

	public static void main(String[] args) {
        // ����ڷκ��� �Է¹ޱ� ���� Scanner ����
        Scanner sc = new Scanner(System.in);

        // �켱 ó���� �� ó���� ����� ������ �ݺ��� �����ؾ� �� �� ���.
        int sum = 0;
        int in;
        do{
            in = sc.nextInt(); // ����ڿ��� �Է��� �޾� ����
            sum += in;
        } while(in != 0);
        System.out.println(sum);

        // while��
//        in = sc.nextInt(); 
//        while(in != 0){
//            sum += in;
//            in = sc.nextInt();
//        }
//        System.out.println(sum);
	}

}
