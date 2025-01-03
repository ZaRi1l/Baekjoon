package q2720;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int money = sc.nextInt();
			int[] change = new int[4];

			change[0] = money / 25;
			change[1] = (money % 25) / 10;
			change[2] = ((money % 25) % 10) / 5;
			change[3] = ((money % 25) % 10) % 5;

			for (int j : change) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
