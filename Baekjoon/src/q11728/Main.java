package q11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] a = new int[Integer.parseInt(st.nextToken())];
		int[] b = new int[Integer.parseInt(st.nextToken())];
		Integer[] ab = new Integer[a.length + b.length];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b.length; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		br.close();

		for (int i = 0; i < ab.length; i++) {
			if (i < a.length) {
				ab[i] = a[i];
			} else {
				ab[i] = b[i - a.length];
			}
		}

		Arrays.sort(ab, (o1, o2) -> o1 - o2);
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ab.length; i++) {
			sb.append(ab[i]).append(' ');
		}
		System.out.print(sb);
	}

}
