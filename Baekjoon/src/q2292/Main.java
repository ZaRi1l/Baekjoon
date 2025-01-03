package q2292;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		1
//		2 - 7	5
//		8 - 19	11
//		20 - 37	17
//		38 - 61 23
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		func(n, 1, 1, 1);
	}
	
	static void func(int n, int a, int b, int room) {
		if (a <= n && n <= b) {
			System.out.println(room);
		} else {
			a = b + 1;
			b = a + (6*room - 1);
			room++;
			
			func(n, a, b, room);
		}
	}

}
