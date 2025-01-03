package q1110;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		// 반복문 사용
		int changeNum = num, changeNum2;
		
		for (int i = 1; ; i++) {
			changeNum2 = changeNum%10*10 + (changeNum/10 + changeNum%10)%10;
			if (changeNum2 == num) {
				System.out.print(i);
				break;
			}
			changeNum = changeNum2;
		}
		
		// 재귀 함수 사용
		// func(num, num, 1);
	}
	
	static void func(int num, int changeNum, int n) {
		changeNum = changeNum%10*10 + (changeNum/10 + changeNum%10)%10;
		if (num == changeNum) System.out.print(n);
		else func(num, changeNum, ++n);
	}

}
