package q10844_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		int[][] stairs = new int[n][10];

		long count = 0;
		for (int i = 0; i < stairs.length; i++) {
			for (int j = 0; j < stairs[i].length; j++) {
				if (i == 0) {
					if (j != 0) {
						stairs[i][j] = 1;
					}
				} else {
					if (j == 0) {
						stairs[i][j] += stairs[i - 1][j + 1] % 1000000000;
					} else if (j == stairs[i].length - 1) {
						stairs[i][j] += stairs[i - 1][j - 1] % 1000000000;
					} else {
						stairs[i][j] += stairs[i - 1][j + 1] % 1000000000;
						stairs[i][j] += stairs[i - 1][j - 1] % 1000000000;
					}
				}

				if (i == stairs.length - 1) {
					count += stairs[i][j];
					count %= 1000000000;
				}
			}
		}

		System.out.println(count);
	}

}
