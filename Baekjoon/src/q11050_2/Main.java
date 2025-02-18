package q11050_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[][] bc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int div = 3;
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		bc = new long[n + 1][k + 1];

		function(n, k);

		System.out.print(bc[n][k]);
	}

	static long function(int n, int k) {
		if (bc[n][k] > 0)
			return bc[n][k];

		if (n == k || k == 0) {
			bc[n][k] = 1;
			return bc[n][k];
		}

		bc[n][k] = function(n - 1, k - 1) + function(n - 1, k);

		return bc[n][k];
	}

}
