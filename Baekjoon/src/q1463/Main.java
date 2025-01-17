package q1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		func(n);
	}

	static void func(int n) {
		int tmp = n;
		int count1 = 0;
		while (n != 1) {

			if ((n) % 5 == 0) {
				n -= 1;
			} else if (n % 3 == 0) {
				n /= 3;
			} else if (n % 2 == 0) {
				n /= 2;
			} else {
				n -= 1;
			}
			count1 += 1;
		}

//		n = tmp;
//		int count2 = 0;
//		while (n != 1) {
//			if (n % 3 == 0) {
//				n /= 3;
//			} else if (n % 2 == 0) {
//				n /= 2;
//			} else {
//				n -= 1;
//			}
//			count2 += 1;
//		}

//		System.out.println(count1 < count2 ? count1 : count2);
		System.out.println(count1);
	}

}
