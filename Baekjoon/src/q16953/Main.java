package q16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		br.close();

		long curr = a;
		int cnt = oper(curr, 1);

		System.out.print(cnt);
	}

	private static int oper(long curr, int cnt) {
		if (curr > b)
			return -1;
		else if (curr == b)
			return cnt;
		else {
			int cnt1 = oper(curr * 2, cnt + 1);
			int cnt2 = oper(curr * 10 + 1, cnt + 1);

			if (cnt1 == -1 && cnt2 == -1)
				return -1;
			else if (cnt1 == -1)
				return cnt2;
			else if (cnt2 == -1)
				return cnt1;
			else
				return cnt1 < cnt2 ? cnt1 : cnt2;
		}

	}

}
