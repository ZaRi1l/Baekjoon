package q2441;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		for (int i = n; i >= 1; i--) {
			System.out.println(" ".repeat(n - i) + "*".repeat(i));
		}

	}

}
