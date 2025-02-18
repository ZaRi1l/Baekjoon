package q11401_4;

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

		long[] b = new long[k + 1];
		long[] a = null;

		for (int i = 0; i < n + 1; i++) {
			a = new long[k + 1];
			int s = i - (n - k) <= 0 ? 0 : i - (n - k);
			for (int j = s; j <= (i < k ? i : k); j++) {
				if (j == 0 || j == i)
					a[j] = 1;
				else
					a[j] = (b[j - 1] + b[j]) % div;
			}

			// 출력
//			for(int x = 0; x < a.length; x++)
//				System.out.print(a[x]+ " ");
//			System.out.println();

			b = a;
		}
		System.out.print(a[k]);

	}
}
