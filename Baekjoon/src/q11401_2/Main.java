package q11401_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int div = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		if (k > n / 2)
			k = n - k;

		int[] b = new int[k + 1];
		int[] a;

		for (int i = 0; i < n + 1; i++) {
			a = new int[k + 1];
			int s = i - k < 0 ? 0 : i - k;
			for (int j = s; j <= (i < k ? i : k); j++) {
				if (j == 0 || j == i)
					a[j] = 1;
				else
					a[j] = (b[j - 1] + b[j]) % div;
			}
			b = a;
		}

		System.out.print(b[k]);
	}
}
