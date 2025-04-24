package q2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		Integer balloon[] = new Integer[n];
		for (int i = 0; i < balloon.length; i++) {
			balloon[i] = Integer.parseInt(st.nextToken());
		}

		int seq[] = new int[n];
		int idx = 0;
		int num = balloon[idx];
		balloon[idx] = null;
		for (int k = 0; k < seq.length; k++) {
			seq[k] = idx + 1;

			if (k == seq.length - 1)
				break;

			for (int i = 0; i < Math.abs(num);) {
				idx = num > 0 ? idx + 1 : idx - 1;
				if (idx < 0)
					idx = n + idx;
				idx %= n;

				if (balloon[idx] != null) {
					i++;
				}
			}
			num = balloon[idx];
			balloon[idx] = null;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < seq.length; i++) {
			sb.append(seq[i]).append(' ');
		}

		System.out.print(sb);
	}

}
