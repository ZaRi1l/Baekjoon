package q11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int idx = 0;
		int peo[] = new int[n];
		int sec[] = new int[n];
		for (int i = 0; i < sec.length; i++) {

			int count = 0;
			while (count < k) {
				if (peo[idx] == 0) {
					count++;
				}
				idx = (idx + 1) % n;

			}

			if (idx == 0)
				peo[n - 1] = 1;
			else
				peo[idx - 1] = 1;
			sec[i] = idx == 0 ? n : idx;
		}

		StringBuffer sb = new StringBuffer();
		sb.append('<');
		for (int i = 0; i < sec.length; i++) {
			sb.append(sec[i]);
			if (i != sec.length - 1) {
				sb.append(", ");
			}
		}
		sb.append('>');

		System.out.print(sb);

	}

}
