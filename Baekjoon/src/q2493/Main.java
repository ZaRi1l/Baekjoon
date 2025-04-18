package q2493;

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

		int[] tops = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < tops.length; i++) {
			tops[i] = Integer.parseInt(st.nextToken());

			for (int j = i - 1; j >= 0; j--) {
				if (tops[j] >= tops[i]) {
					r[i] = j + 1;
					break;
				}
				
				if (j != 0)
					j = r[j];
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i : r) {
			sb.append(i).append(' ');
		}
		System.out.print(sb);

	}

}
