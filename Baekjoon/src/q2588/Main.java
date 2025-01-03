package q2588;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		sc.close();
		
		int[] result = new int[4];
		result[0] = a * (b % 10);
		result[1] = a * (b % 100 / 10);
		result[2] = a * (b / 100);
		result[3] = result[0] + result[1] * 10 + result[2] * 100;
		
		for (int i : result) {
			System.out.println(i);
		}
	}

}
