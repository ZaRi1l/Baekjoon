package q15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int n = Integer.parseInt(st.nextToken()); // 몇 까지인지
		int m = Integer.parseInt(st.nextToken()); // 남은 수열

		int[] seq = new int[m];

		backTrack(n, 0, seq);

	}

	static void backTrack(int n, int idx, int[] seq) {
		if (idx == seq.length) {
			StringBuffer sb = new StringBuffer();
			for (int num : seq) {
				sb.append(num).append(" ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = 1; i <= n; i++) {

			if (isContain(seq, idx, i)) {
				continue;
			}

			seq[idx] = i;
			backTrack(n, idx + 1, seq);

		}
	}

	static boolean isContain(int[] seq, int idx, int i) {
		boolean b = false;

		for (int a = 0; a < idx; a++) {
			if (i == seq[a]) {
				b = true;
			}
		}

		return b;
	}

}
