package q2445;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 2 * n; i++) {
			for (int j = 1; j <= 2 * n; j++) {

				if (i <= n) {
					if (j <= i || j > 2 * n - i)
						sb.append('*');
					else
						sb.append(' ');
				} else {
					if (j > i || j <= 2 * n - i)
						sb.append('*');
					else
						sb.append(' ');
				}
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}

}
