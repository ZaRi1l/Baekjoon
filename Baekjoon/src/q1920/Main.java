package q1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		br.close();

		StringBuffer sb = new StringBuffer();
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			int a = 0;
			int b = arr.length;
			int idx = arr.length / 2;

			int exist = 0;
			while (true) {
				
				if (arr[idx] > num) {
					b = idx;
					idx = (idx - a) / 2 + a;
				} else if (arr[idx] < num) {
					a = idx;
					idx = (b - idx) / 2 + idx;
				}

				if (arr[idx] == num) {
					exist = 1;
					break;
				}
				if (a == b || a + 1 == b) {
					break;
				}
//				System.out.println(a + " " + b);
			}
			sb.append(exist).append('\n');
		}
		System.out.println(sb);
	}

}
