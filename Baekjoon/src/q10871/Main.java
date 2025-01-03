package q10871;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] seq = new int[sc.nextInt()];
		int n = sc.nextInt();
		
		for (int i = 0; i < seq.length; i++) {
			seq[i] = sc.nextInt();
		}
		sc.close();
		
		for (int i = 0; i < seq.length; i++) {
			if (seq[i] < n) System.out.printf("%d ", seq[i]);
		}
		
	}

}
