package forWhile;

import java.util.Scanner;

public class DoWhileTest {

	public static void main(String[] args) {
        // 사용자로부터 입력받기 위해 Scanner 선언
        Scanner sc = new Scanner(System.in);

        // 우선 처리한 후 처리한 결과를 가지고 반복을 결정해야 할 때 사용.
        int sum = 0;
        int in;
        do{
            in = sc.nextInt(); // 사용자에게 입력을 받아 저장
            sum += in;
        } while(in != 0);
        System.out.println(sum);

        // while문
//        in = sc.nextInt(); 
//        while(in != 0){
//            sum += in;
//            in = sc.nextInt();
//        }
//        System.out.println(sum);
	}

}
