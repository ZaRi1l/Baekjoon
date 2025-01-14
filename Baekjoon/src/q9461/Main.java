package q9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long[] p = new long[100];

		for (int i = 0; i < p.length; i++) {
			if (0 <= i && i <= 2) {
				p[i] = 1;
			} else if (3 <= i && i <= 4) {
				p[i] = 2;
			} else {
				p[i] = p[i - 1] + p[i - 5];
			}
		}

		for (int i = 0; i < t; i++) {
			System.out.println(p[Integer.parseInt(br.readLine()) - 1]);
		}
		br.close();
	}
}
