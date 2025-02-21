package q2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char met[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		met = new char[n][n];

		btk(0, 0, n);

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < met.length; i++) {
			for (int j = 0; j < met[i].length; j++) {
				sb.append(met[i][j] == 0 ? ' ' : met[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

	static void btk(int x, int y, int n) {
		if (n == 3) {
			pattern(x, y);
			return;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1)
					continue;

				btk(x + i * n / 3, y + j * n / 3, n / 3);
			}
		}
	}

	static void pattern(int x, int y) {
		for (int i = 0; i < 9; i++) {
			if (i / 3 == 1 && i % 3 == 1)
				met[x + i / 3][y + i % 3] = ' ';
			else
				met[x + i / 3][y + i % 3] = '*';
		}
	}

}
