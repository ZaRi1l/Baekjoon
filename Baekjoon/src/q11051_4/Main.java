package q11051_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] bc;
	static int div = 10007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		bc = new int[n + 1][k + 1];

		for (int i = 0; i < bc.length; i++) {

			for (int j = 0; j <= (i < k ? i : k); j++) {
				if (j == 0 || j == i)
					bc[i][j] = 1;
				else
					bc[i][j] = (bc[i - 1][j - 1] + bc[i - 1][j]) % div;
			}
		}
		System.out.print(bc[n][k]);
	}
}
