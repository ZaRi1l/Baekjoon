package q10810;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] basket = new int[n];

		for (int i = 0; i < m; i++) {
			int fr = sc.nextInt() - 1;
			int la = sc.nextInt() - 1;
			int num = sc.nextInt();

			for (int j = fr; j <= la; j++) {
				basket[j] = num;
			}
		}

		sc.close();

		for (int i = 0; i < basket.length; i++) {
			System.out.print(basket[i] + " ");
		}
	}
}
