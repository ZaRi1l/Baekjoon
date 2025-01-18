package q15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n - m + 1; i++) {
			int[] seq = new int[m];
			seq[0] = i;

			func(n, m, seq, 0);
		}
	}

	static void func(int n, int m, int[] seq, int idx) {
		if (idx != m - 1) {
			if (seq[idx] < n) {
				for (int i = 1; i <= n - seq[idx]; i++) {
					seq[idx + 1] = i + seq[idx];
					func(n, m, seq, idx + 1);
				}
			}
		} else {
			for (int i = 0; i < seq.length; i++) {
				System.out.print(seq[i] + " ");
			}
			System.out.println();
		}
	}

}
