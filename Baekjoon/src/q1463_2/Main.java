package q1463_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		int num[] = new int[n];

		if (n > 0)
			num[0] = 0;
		if (n > 1)
			num[1] = 1;
		if (n > 2)
			num[2] = 1;

		for (int i = 3; i < num.length; i++) {
			int a, b, c;
			if ((i + 1) % 3 == 0) {
				a = (i + 1) / 3 - 1;
			} else {
				a = i - 1;
			}
			if ((i + 1) % 2 == 0) {
				b = (i + 1) / 2 - 1;
			} else {
				b = i - 1;
			}
			c = i - 1;

			num[i] = Math.min(num[a], Math.min(num[b], num[c])) + 1;
		}

		System.out.println(num[num.length - 1]);
	}

}
