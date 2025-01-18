package q2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		int m = 0;
		for (int i = n - 1; i >= 0; i--) {
			String str = Integer.toString(i);
			int sum = i;

			for (int j = 0; j < str.length(); j++) {
				sum += Character.getNumericValue(str.charAt(j));
			}

			if (n == sum) {
				m = i;
			}
		}

		System.out.print(m);

	}

}
