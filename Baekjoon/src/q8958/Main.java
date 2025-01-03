package q8958;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tot = sc.nextInt();
		
		for (int i = 0; i < tot; i++) {
			String res = sc.next();
			int sum = 0, count = 1;
			
			for (int j = 0; j < res.length(); j++) {
				if (res.charAt(j) == 'X') {
					count = 1;
				} else {
					sum += count;
					count++;
				}
			}
			
			System.out.println(sum);
		}
		
		sc.close();
	}

}
